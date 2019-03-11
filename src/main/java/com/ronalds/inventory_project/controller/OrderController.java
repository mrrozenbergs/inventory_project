package com.ronalds.inventory_project.controller;

import com.ronalds.inventory_project.entity.*;
import com.ronalds.inventory_project.service.*;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order_control")
public class OrderController {

    private ProductService productService;

    private ClientService clientService;

    private UserService userService;

    private OrderService orderService;


    @Autowired
    private CartService cartService;


    public OrderController(ProductService productService, ClientService clientService, OrderService orderService, CartService cartService, UserService userService) {
        this.productService = productService;
        this.clientService = clientService;
        this.orderService = orderService;
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listOfOrders(Model model) {

        List<Product> products = productService.findAll();

        model.addAttribute("product", products);

        return "/products/list-products";
    }

    @GetMapping("/orderlist")
    public String ordersForClient(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName()).get();
        List<Order> clientOrders = user.getClient().getOrders();
        model.addAttribute("orders", clientOrders);
        return "/orders/list-orders-client";
    }


    @GetMapping("/add_order")
    public String addNewOrder(Model model) {

        List<Product> product = productService.findAll();

        Order order = new Order();

        model.addAttribute("product", product);
        model.addAttribute("order", order);

        return "/orders/order-form";
    }


    @PostMapping("/create")
    public String saveOrder(Model model, CartService cartService, HttpServletRequest request, Principal principal) {

        orderService.saveOrder(cartService, request, principal);

        return "redirect:/orders/add_order";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("orderId") int Id) {

        orderService.removeOrder(Id);

        return "redirect:/orders/list";
    }

}

package com.ronalds.inventory_project.controller;

import com.ronalds.inventory_project.entity.*;
import com.ronalds.inventory_project.error.NotEnoughProductsInStockException;
import com.ronalds.inventory_project.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/orders")
@SessionAttributes("order_control")
public class OrderController {

    private ProductService productService;

    private UserService userService;

    private OrderService orderService;

    @Autowired
    private CartService cartService;


    public OrderController(ProductService productService, OrderService orderService, CartService cartService, UserService userService) {
        this.productService = productService;
        this.orderService = orderService;
        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping("/list")
    public String listOfOrders(Model model) {

        List<Order> orders = orderService.findAllOrders();

        model.addAttribute("orders", orders);

        return "/orders/list-orders";
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

    @PostMapping("showOrderDetail")
    public String showOrderDetail(@RequestParam("order-id") int Id, Model model){

        Order order = orderService.findOrderById(Id);

        List<OrderDetails> orderdetails = order.getOrderEntries();

        model.addAttribute("order", order);
        model.addAttribute("orderdetails", orderdetails);

        return "/orders/details";
    }


    @PostMapping("/create")
    public String saveOrder(Model model, CartService cartService, HttpServletRequest request, Principal principal) {

        try {
            orderService.saveOrder(cartService, request, principal);
        } catch (NotEnoughProductsInStockException e) {
            e.printStackTrace();
            return "redirect:/notEnoughProducts";
        }

        return "redirect:/orders/orderlist";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("order-id") int Id) {

        orderService.removeOrder(Id);

        return "redirect:/orders/list";
    }

}

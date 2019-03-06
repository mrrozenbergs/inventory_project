package com.ronalds.inventory_project.controller;

import com.ronalds.inventory_project.entity.Client;
import com.ronalds.inventory_project.entity.Order;
import com.ronalds.inventory_project.entity.OrderDetails;
import com.ronalds.inventory_project.entity.Product;
import com.ronalds.inventory_project.service.*;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order_control")
public class OrderController {

    private ProductService productService;

    private ClientService clientService;

    private OrderService orderService;

    private OrderDetailService orderDetailService;

    @Autowired
    private CartService cartService;


    public OrderController(ProductService productService, ClientService clientService, OrderService orderService, CartService cartService) {
        this.productService = productService;
        this.clientService = clientService;
        this.orderService = orderService;
        this.cartService = cartService;
    }


    @GetMapping("/list")
    public String listClients(Model model) {

        List<Product> products = productService.findAll();

        model.addAttribute("product", products);

        return "/products/list-products";
    }

    @GetMapping("/add_order")
    public String addNewOrder(Model model) {

        List<Product> product = productService.findAll();

        Order order = new Order();

        model.addAttribute("product", product);
        model.addAttribute("order", order);

        return "/orders/order-form";
    }

//    @GetMapping("/add_list")
//    public String addTolist(@ModelAttribute("order_detail") OrderDetails orderDetails) {
//
////        orderDetailsList.add(orderDetails);
//
//        return "/orders/order-form";
//    }

    @PostMapping("/save_order_detail")
    public String saveOrderDetail(@ModelAttribute("order_detail") OrderDetails orderDetails,@ModelAttribute("order") Order order) {

        orderDetails.setOrder(order);
//        orderDetailsList.add(orderDetails);
//        orderDetailService.saveOrderEntry(orderDetails);

        return "redirect:/orders/add_order";
    }

    @PostMapping("/create")
    public String saveOrder(Model model, CartService cartService, HttpServletRequest request) {

       orderService.saveOrder(cartService, request);

        return "redirect:/orders/add_order";
    }


    @PostMapping("/delete")
    public String delete(@RequestParam("orderId") int Id) {

        orderService.removeOrder(Id);

        return "redirect:/orders/list";
    }

    @PostMapping("/delete_order_detail")
    public String deleteOrderDetail(@RequestParam("orderDetailId") int Id) {

        orderDetailService.removeOrderDetails(Id);

        return "redirect:/orders/list";
    }


}

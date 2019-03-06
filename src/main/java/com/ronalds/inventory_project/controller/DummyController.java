package com.ronalds.inventory_project.controller;

import com.ronalds.inventory_project.entity.Order;
import com.ronalds.inventory_project.entity.OrderDetails;
import com.ronalds.inventory_project.entity.Product;
import com.ronalds.inventory_project.service.ClientService;
import com.ronalds.inventory_project.service.OrderDetailService;
import com.ronalds.inventory_project.service.OrderService;
import com.ronalds.inventory_project.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/dummy/orders")
public class DummyController {

    private final OrderService orderService;
    private final ClientService clientService;
    private final ProductService productService;
    private final OrderDetailService orderDetailService;


    public DummyController(OrderService orderService, ClientService clientService, ProductService productService, OrderDetailService orderDetailService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.productService = productService;
        this.orderDetailService = orderDetailService;
    }

//    @GetMapping("/add_order")
//    public Order addNewOrder() {
//        Order order= new Order();
//        order.setDate(new Date());
//        order.setTotalPrice(5);
//        order.setCustomer(clientService.findById(3));
//        return orderService.saveOrder(order);
//    }

    @GetMapping("/add_order_detail")
    public OrderDetails addNewOrderDetail() {
        Product product=productService.findProductById(1);
        OrderDetails orderDetails=new OrderDetails();
//        orderDetails.setAmount(2);
//        orderDetails.setOrder(addNewOrder());
//        orderDetails.setPrice(product.getPrice());
        orderDetails.setProduct(product);
        return orderDetailService.saveOrderEntry(orderDetails);
    }

    @GetMapping("/getOrderDetail/{id}")
    public OrderDetails getOrderDetail(@RequestParam("id") int id) {
        OrderDetails orderDetails=orderDetailService.findOrderDetailsById(id);
        return orderDetails;
    }

}

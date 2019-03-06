package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.entity.Order;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrderService  {

    public List<Order> findAllOrders();

    public Order findOrderById(int Id);

    public Order saveOrder(CartService cartService, HttpServletRequest request);

    public void removeOrder(int Id);



}

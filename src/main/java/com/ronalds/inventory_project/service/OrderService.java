package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.entity.Client;
import com.ronalds.inventory_project.entity.Order;
import com.ronalds.inventory_project.error.NotEnoughProductsInStockException;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

public interface OrderService  {

    List<Order> findAllOrders();

    Order findOrderById(int Id);

    Order saveOrder(CartService cartService, HttpServletRequest request, Principal principal) throws NotEnoughProductsInStockException;

    void removeOrder(int Id);

}

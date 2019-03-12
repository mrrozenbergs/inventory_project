package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.entity.Client;
import com.ronalds.inventory_project.entity.Order;
import com.ronalds.inventory_project.error.NotEnoughProductsInStockException;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

public interface OrderService  {

    public List<Order> findAllOrders();

    public Order findOrderById(int Id);

    public Order saveOrder(CartService cartService, HttpServletRequest request, Principal principal) throws NotEnoughProductsInStockException;

    public void removeOrder(int Id);

}

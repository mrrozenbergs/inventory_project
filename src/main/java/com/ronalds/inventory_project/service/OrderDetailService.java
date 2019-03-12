package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.entity.Order;
import com.ronalds.inventory_project.entity.OrderDetails;

import java.util.List;

public interface OrderDetailService {

    public List<OrderDetails> findAllOrders();

    public OrderDetails findOrderDetailsById(int Id);

    public OrderDetails saveOrderEntry(OrderDetails orderDetails);

    public void removeOrderDetails(int Id);
}

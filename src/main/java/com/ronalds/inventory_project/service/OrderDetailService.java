package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.entity.Order;
import com.ronalds.inventory_project.entity.OrderDetails;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetails> findAllOrders();

    OrderDetails findOrderDetailsById(int Id);

    OrderDetails saveOrderEntry(OrderDetails orderDetails);

    void removeOrderDetails(int Id);
}

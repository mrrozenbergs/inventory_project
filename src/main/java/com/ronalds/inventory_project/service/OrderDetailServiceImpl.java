package com.ronalds.inventory_project.service;


import com.ronalds.inventory_project.dao.OrderDetailRepository;
import com.ronalds.inventory_project.entity.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService{


    private OrderDetailRepository orderDetailRepository;


    @Autowired
    public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository){this.orderDetailRepository = orderDetailRepository;}


    @Override
    public List<OrderDetails> findAllOrders() {
        return orderDetailRepository.findAllByOrderById();
    }

    @Override
    public OrderDetails findOrderDetailsById(int Id) {
        Optional<OrderDetails> result = orderDetailRepository.findById(Id);

        OrderDetails orderDetails = null;

        if (result.isPresent()) {
            orderDetails = result.get();
        } else {
            throw new RuntimeException("Did not find OrderDetail id - " + Id);
        }

        return orderDetails;
    }

    @Override
    public OrderDetails saveOrderEntry(OrderDetails orderDetails) {
        return orderDetailRepository.save(orderDetails);
    }

    @Override
    public void removeOrderDetails(int Id) {
        orderDetailRepository.deleteById(Id);
    }
}

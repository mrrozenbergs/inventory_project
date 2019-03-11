package com.ronalds.inventory_project.dao;

import com.ronalds.inventory_project.entity.Client;
import com.ronalds.inventory_project.entity.Order;
import com.ronalds.inventory_project.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    public List<Order> findAllByOrderById();

}

package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findProductById(int Id);

    void saveProduct(Product product);

    void removeProduct(int Id);
}

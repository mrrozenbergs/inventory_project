package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAll();

    public Product findProductById(int Id);

//    public Product addToStock(int Id, int number);
//
//    public Product deleteFromStock(int Id, int number);

    public void saveProduct(Product product);

    public void removeProduct(int Id);
}

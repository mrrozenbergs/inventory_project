package com.ronalds.inventory_project.service;

import com.ronalds.inventory_project.dao.ProductRepository;
import com.ronalds.inventory_project.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAllByOrderById();
    }

    @Override
    public Product findProductById(int Id) {

        Optional<Product> result = productRepository.findById(Id);

        Product product = null;

        if (result.isPresent()) {
            product = result.get();
        } else {
            throw new RuntimeException("Did not find Product id - " + Id);
        }

        return product;
    }

//    @Override
//    public Product addToStock(int Id, int number) {
//        Product productById = findProductById(Id);
//        productById.setInStock(number);
//        return productById;
//    }
//
//    @Override
//    public Product deleteFromStock(int Id, int number) {
//        Product productById = findProductById(Id);
//        productById.setInStock(number);
//        return productById;
//    }

    @Override
    public void saveProduct(Product product) {
    productRepository.save(product);
    }

    @Override
    public void removeProduct(int Id) {
    productRepository.deleteById(Id);
    }
}

package com.ronalds.inventory_project.service.model;

import com.ronalds.inventory_project.entity.OrderDetails;
import com.ronalds.inventory_project.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class Cart {

    private Map<Integer, OrderDetails> productMap;

    private List<OrderDetails> orderDetailsList;

    private List<Product> productList;

    private int numberOfItems;

    private double total;


    public Cart() {
        productMap = new ConcurrentHashMap<Integer, OrderDetails>();
    }

    public void addToCart(Integer id, OrderDetails orderDetails) {
        productMap.put(id, orderDetails);
    }

    public int getNumberOfItems() {
        numberOfItems = 0;
        List<OrderDetails> itemsList = new ArrayList<>();
        itemsList.addAll(productMap.values());
        for (OrderDetails item : itemsList) {
            numberOfItems += item.getQuantity();
        }
        return numberOfItems;
    }

    public boolean contains(Integer productId) {
        return productMap.containsKey(productId);
    }

    public void incrementProductQuantity(Integer productId) {
        OrderDetails orderItem = productMap.get(productId);
        orderItem.incrementQuantity();
    }

    public void clearCart() {
        productMap.clear();
        numberOfItems = 0;
    }

    public void decrementProductQuantity(Integer productId) {
        OrderDetails orderItem = productMap.get(productId);
        orderItem.decrementQuantity();
    }

    public void removeProduct(Integer productId) {
        decrementProductQuantity(productId);
        productMap.remove(productId);
    }

    public List<OrderDetails> getOrderItemsList() {
        orderDetailsList = new ArrayList<>(productMap.values());
        return orderDetailsList;
    }


    public double getTotal() {
        double amount = 0.0;
        for (OrderDetails item : productMap.values()) {
            amount = amount + (item.getTotal()).doubleValue();
        }
        total = amount;
        return total;
    }

    public boolean isCartEmpty() {
        return productMap.isEmpty();
    }

    public OrderDetails getProduct(Integer productId) {
        return productMap.get(productId);
    }

    public int getCartSize() {
        return productMap.size();
    }

    public boolean containsKey(Integer productId) {
        return productMap.containsKey(productId);
    }


}

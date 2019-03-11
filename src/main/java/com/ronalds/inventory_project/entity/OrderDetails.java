package com.ronalds.inventory_project.entity;


import com.ronalds.inventory_project.entity.Order;
import com.ronalds.inventory_project.entity.Product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_detail")
public class OrderDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_detail_id", nullable = false)
    private int id;

    @Column(name = "quantity")
    private int quantity;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderDetails() {
    }

    public OrderDetails(int id, int quantity, Product product, Order order) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
        this.order = order;
    }

    public OrderDetails(int quantity, Product product, Order order) {
        this.quantity = quantity;
        this.product = product;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int amount) {
        this.quantity = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void incrementQuantity() {
        quantity++;
    }

    public BigDecimal getTotal() {
        double amount = 0.0;
        if (product != null) {
            amount = amount + product.getPrice() * quantity;
        }
        return new BigDecimal(amount);
    }

    public void decrementQuantity() {
        quantity--;

    }

    @Override
    public String toString() {
        return  "id=" + id + ", product=" + product.getProductName() + ", quantity=" + quantity + "\r\n";
    }
}

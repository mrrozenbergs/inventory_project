package com.ronalds.inventory_project.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordering")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column (name = "date")
    private Date date;

    @Column (name = "total_price")
    private double totalPrice;

    @OneToMany(cascade=CascadeType.ALL)
    private List<OrderDetails> orderEntries;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client customer;

    public Order() {
    }

    public Order(List<OrderDetails> orderEntries, Client customer) {
        this.orderEntries = orderEntries;
        this.customer = customer;
    }

    public Order(int id, Date date, List<OrderDetails> orderEntries, double totalPrice, Client customer) {
        this.id = id;
        this.date = date;
        this.orderEntries = orderEntries;
        this.totalPrice = totalPrice;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderDetails> getOrderEntries() {
        return orderEntries;
    }

    public void setOrderEntries(List<OrderDetails> orderEntries) {
        this.orderEntries = orderEntries;
    }

    public Client getCustomer() {
        return customer;
    }

    public void setCustomer(Client customer) {
        this.customer = customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

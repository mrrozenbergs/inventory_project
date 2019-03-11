package com.ronalds.inventory_project.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordering")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int id;

    @Column (name = "date")
    private Date date;

    @Column (name = "total_price")
    private double totalPrice;

    @OneToMany(cascade=CascadeType.ALL)
    private List<OrderDetails> orderEntries;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinTable(name = "client_orders", joinColumns = @JoinColumn(name = "orders_id"), inverseJoinColumns = @JoinColumn(name = "clients_id"))
    private Client client;

    public Order() {
    }

    public Order(List<OrderDetails> orderEntries, Client client) {
        this.orderEntries = orderEntries;
        this.client = client;
    }

    public Order(int id, Date date, List<OrderDetails> orderEntries, double totalPrice, Client client) {
        this.id = id;
        this.date = date;
        this.orderEntries = orderEntries;
        this.totalPrice = totalPrice;
        this.client = client;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

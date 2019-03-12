package com.ronalds.inventory_project.entity;


import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "client")
public class Client{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private int id;

    @Column(name = "company_name", nullable = false, unique = true)
    private String companyName;

    @Column(name = "reg_no", nullable = false, unique = true)
    private String registrationNumber;

    @Column(name = "contacts")
    private String contacts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private List<User> users;

    public Client() {
    }

    public Client(int id, String companyName, String registrationNumber, String contacts, List<Order> orders, List<User> users) {
        this.id = id;
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.contacts = contacts;
        this.orders = orders;
        this.users = users;
    }

    public Client(int id, String companyName, String registrationNumber, String contacts, List<Order> orders) {
        this.id = id;
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.contacts = contacts;
        this.orders = orders;
    }

    public Client(String companyName, String registrationNumber, String contacts, String email, String password) {
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.contacts = contacts;
    }

    public Client(String companyName, String registrationNumber, String contacts) {
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.contacts = contacts;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", contacts='" + contacts + '\'' +
                ", orders=" + orders +
                '}';
    }
}












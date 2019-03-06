package com.ronalds.inventory_project.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "client")
public class Client implements Serializable {

    private static final long serialVersionUID = -3075727814481272627L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "reg_no")
    private String registrationNumber;

    @Column(name = "contacts")
    private String contacts;

    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    @Column(name = "email")
    private String email;

    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    @Column(name = "password")
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Order> orders;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Role> roles;


    public Client() {
    }

    public Client(int id, String companyName, String registrationNumber, String contacts, @Email(message = "*Please provide a valid Email") @NotEmpty(message = "*Please provide an email") String email, @Length(min = 5, message = "*Your password must have at least 5 characters") @NotEmpty(message = "*Please provide your password") String password, List<Order> orders, Set<Role> roles) {
        this.id = id;
        this.companyName = companyName;
        this.registrationNumber = registrationNumber;
        this.contacts = contacts;
        this.email = email;
        this.password = password;
        this.orders = orders;
        this.roles = roles;
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
        this.email = email;
        this.password = password;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", contacts='" + contacts + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", orders=" + orders +
                '}';
    }
}












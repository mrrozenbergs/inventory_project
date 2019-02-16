package com.ronalds.inventory_project.entity;

import javax.persistence.*;
import java.io.Serializable;

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


    public Client() {

    }

    public Client(int id, String companyName, String registrationNumber, String contacts) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Client [id=" + id + ", firstName=" + companyName + ", registrationNumber=" + registrationNumber + ", contacts=" + contacts + "]";
    }

}












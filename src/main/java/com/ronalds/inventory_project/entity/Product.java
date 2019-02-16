package com.ronalds.inventory_project.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    private static final long serialVersionUID = 3638672164426743937L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "productname")
    private String productName;

    @Column(name = "eannumber")
    private String eanNumber;

    @Column(name = "instock")
    private int inStock;

    @Column(name = "price")
    private double price;

    public Product() {
    }

    public Product(int id, String productName, String eanNumber, int inStock, double price) {
        this.id = id;
        this.productName = productName;
        this.eanNumber = eanNumber;
        this.inStock = inStock;
        this.price = price;
    }

    public Product(String productName, String eanNumber, int inStock, double price) {
        this.productName = productName;
        this.eanNumber = eanNumber;
        this.inStock = inStock;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEanNumber() {
        return eanNumber;
    }

    public void setEanNumber(String eanNumber) {
        this.eanNumber = eanNumber;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", eanNumber='" + eanNumber + '\'' +
                ", inStock=" + inStock +
                ", price=" + price +
                '}';
    }
}

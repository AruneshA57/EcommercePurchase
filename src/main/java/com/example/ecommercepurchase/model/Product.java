package com.example.ecommercepurchase.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Long productQnty;
    private Long productCost;



    public Product(String productName, Long productQnty, Long productCost) {
        this.productName = productName;
        this.productQnty = productQnty;
        this.productCost = productCost;
    }

    public Product(){}

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductQnty() {
        return productQnty;
    }

    public void setProductQnty(Long productQnty) {
        this.productQnty = productQnty;
    }

    public Long getProductCost() {
        return productCost;
    }

    public void setProductCost(Long productCost) {
        this.productCost = productCost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productQnty=" + productQnty +
                ", productCost=" + productCost +
                '}';
    }
}

package com.example.ecommercepurchase.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productQnty;

    private Long productCost;

    public Product(String productQnty, Long productCost) {
        this.productQnty = productQnty;
        this.productCost = productCost;
    }

    public Product(){}

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductQnty() {
        return productQnty;
    }

    public void setProductQnty(String productQnty) {
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
                ", productQnty='" + productQnty + '\'' +
                ", productCost='" + productCost + '\'' +
                '}';
    }
}

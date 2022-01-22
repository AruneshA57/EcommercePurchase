package com.example.ecommercepurchase.model;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Order  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Long userId;
    private Long productId;
    private Long quantity;
    @Column(nullable = true)
    private String coupon;
    private Long totalPrice;

    public Order() {

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order(Long userId, Long productId, Long quantity, String coupon) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.coupon = coupon;
    }
}

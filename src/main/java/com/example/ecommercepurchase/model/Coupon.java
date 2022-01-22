package com.example.ecommercepurchase.model;

import javax.persistence.*;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String coupon;
    private Long couponValue;

    public Coupon() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coupon(String coupon, Long couponValue) {
        this.coupon = coupon;
        this.couponValue = couponValue;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public Long getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(Long couponValue) {
        this.couponValue = couponValue;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", coupon='" + coupon + '\'' +
                ", couponValue=" + couponValue +
                '}';
    }
}

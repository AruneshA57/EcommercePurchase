package com.example.ecommercepurchase.model;

import javax.persistence.*;

@Entity
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String couponName;
    @Column(nullable = false)
    private Long couponValue;

    public Coupon() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Coupon(String couponName, Long couponValue) {
        this.couponName = couponName;
        this.couponValue = couponValue;
    }


    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String coupon) {
        this.couponName = coupon;
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
                ", coupon='" + couponName + '\'' +
                ", couponValue=" + couponValue +
                '}';
    }
}

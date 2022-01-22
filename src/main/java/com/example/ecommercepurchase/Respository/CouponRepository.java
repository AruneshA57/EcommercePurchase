package com.example.ecommercepurchase.Respository;

import com.example.ecommercepurchase.model.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon,Long> {

    Coupon getCouponByCouponName (String couponName);
    Boolean existsCouponByCouponName(String couponName);

}

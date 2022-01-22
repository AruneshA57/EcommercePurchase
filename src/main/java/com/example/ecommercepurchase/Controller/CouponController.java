package com.example.ecommercepurchase.Controller;

import com.example.ecommercepurchase.Service.CouponService;
import com.example.ecommercepurchase.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("add")
    public ResponseEntity<Coupon> addCoupon(@RequestBody Coupon coupon){
        Coupon newCoupon = couponService.addCoupon(coupon);
        return new ResponseEntity<>(newCoupon, HttpStatus.CREATED);
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Coupon>> getAll(){
        List<Coupon> coupons = couponService.getAll();
        return new ResponseEntity<>(coupons,HttpStatus.OK);
    }
}

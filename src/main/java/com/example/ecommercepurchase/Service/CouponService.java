package com.example.ecommercepurchase.Service;

import com.example.ecommercepurchase.Respository.CouponRepository;
import com.example.ecommercepurchase.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CouponService  {

    private final CouponRepository couponRepository;

    @Autowired
    public CouponService(CouponRepository couponRepository) {
        this.couponRepository = couponRepository;
    }

    public Coupon addCoupon(Coupon coupon){
       return couponRepository.save(coupon);
    }


    public List<Coupon> getAll(){
        return couponRepository.findAll();
    }


}

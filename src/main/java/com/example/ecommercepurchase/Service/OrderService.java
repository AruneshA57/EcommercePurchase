package com.example.ecommercepurchase.Service;

import com.example.ecommercepurchase.Respository.CouponRepository;
import com.example.ecommercepurchase.Respository.OrderRepository;
import com.example.ecommercepurchase.Respository.ProductRepository;
import com.example.ecommercepurchase.Respository.UserRepository;
import com.example.ecommercepurchase.model.Coupon;
import com.example.ecommercepurchase.model.Order;
import com.example.ecommercepurchase.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private  final ProductRepository productRepository;
    private final CouponRepository couponRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository, CouponRepository couponRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.couponRepository = couponRepository;
    }



    public List<Order> getAll(){
        return orderRepository.findAll();
    }



    public Order addOrder(Order order){
        Product product = productRepository.getProductByProductId(order.getProductId());
        if(order.getCoupon()==null) order.setTotalPrice(product.getProductCost()* order.getQuantity());
        else {
            Coupon coupon = couponRepository.getCouponByCouponName(order.getCoupon());
            Long discount = 100L - coupon.getCouponValue();
            order.setTotalPrice(product.getProductCost()* order.getQuantity()*discount/100L);
        }
        return orderRepository.save(order);
    }

    public void deleteAll(){
        orderRepository.deleteAll();
    }

    public Boolean prodIdExist(Long id){
        return productRepository.existsById(id);
    }

    public Boolean userIdExist(Long id){
        return userRepository.existsById(id);
    }
    public Boolean existsCoupon(String coupon){
        return couponRepository.existsCouponByCouponName(coupon);
    }
    public Boolean existsOrderById(Long id){
        return  orderRepository.existsOrderById(id);
    }
    public  Order getOrder(Long id){
        return orderRepository.getOrderById(id);
    }
}

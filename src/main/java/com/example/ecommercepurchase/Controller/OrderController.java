package com.example.ecommercepurchase.Controller;

import com.example.ecommercepurchase.Service.OrderService;
import com.example.ecommercepurchase.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("getAll")
    public ResponseEntity<List<Order>> getAll(){
        List<Order> orders = orderService.getAll();
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody Order order) throws Throwable{
        if(orderService.prodIdExist(order.getProductId())){
            if(orderService.userIdExist(order.getUserId())){
                if(orderService.existsCoupon(order.getCoupon())){
                    if(orderService.checkQnty(order.getProductId(), order.getQuantity())){
                        Order newOrder = orderService.addOrder(order);
                        return new ResponseEntity<>(newOrder, HttpStatus.OK);
                    }
                   throw new Exception("Invalid Quantity");
                }
                throw new Exception("Invalid Coupon");
            }
            throw new IllegalStateException("UserId not found");
        }
        throw new IllegalStateException("ProductId not found");
    }

    @DeleteMapping("deleteAll")
    public void deleteAll(){
        orderService.deleteAll();
    }

}

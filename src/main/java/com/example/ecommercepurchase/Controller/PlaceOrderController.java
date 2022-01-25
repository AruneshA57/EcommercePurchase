package com.example.ecommercepurchase.Controller;

import com.example.ecommercepurchase.Service.OrderService;
import com.example.ecommercepurchase.Respository.PlaceOrderRepo;
import com.example.ecommercepurchase.Service.OrderService;
import com.example.ecommercepurchase.Service.PlaceOrderService;
import com.example.ecommercepurchase.Service.ProductService;
import com.example.ecommercepurchase.model.PayAndPlaceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("PlaceOrder")
public class PlaceOrderController {

    @Autowired
    private PlaceOrderService placeOrderService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @PostMapping("pay")
    public ResponseEntity<List<Object>> placeOrder(@RequestBody PayAndPlaceOrder payAndPlaceOrder) throws Throwable{
        if(orderService.existsOrderById(payAndPlaceOrder.getOrderId())){
            if(Objects.equals(payAndPlaceOrder.getAmount(),
                    orderService.getOrder(payAndPlaceOrder.getOrderId()).getTotalPrice())){
                PayAndPlaceOrder newOrder = placeOrderService.placeOrder(payAndPlaceOrder);
                productService.reduceStockQnty(payAndPlaceOrder.getOrderId());
                List<Object> list= new ArrayList<>(2);
                list.add(newOrder);
                list.add(productService.getProductByOrderID(payAndPlaceOrder.getOrderId()));
                return new ResponseEntity<>(list,HttpStatus.OK);
            }
            throw new Exception("Invalid Amount");
        }
        throw new Exception("Invalid OrderID");
    }







}

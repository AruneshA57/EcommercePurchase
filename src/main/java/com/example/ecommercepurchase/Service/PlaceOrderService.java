package com.example.ecommercepurchase.Service;

import com.example.ecommercepurchase.Respository.OrderRepository;
import com.example.ecommercepurchase.Respository.PlaceOrderRepo;
import com.example.ecommercepurchase.Respository.ProductRepository;
import com.example.ecommercepurchase.model.Order;
import com.example.ecommercepurchase.model.PayAndPlaceOrder;
import com.example.ecommercepurchase.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Service
@Transactional
public class PlaceOrderService {

    @Autowired
    private PlaceOrderRepo placeOrderRepo;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;

    public PayAndPlaceOrder placeOrder(PayAndPlaceOrder payAndPlaceOrder) {

        String pattern = "dd/MM/yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        payAndPlaceOrder.setDate(simpleDateFormat.format(new Date()));
        payAndPlaceOrder.setStatus("Successfully placed");
        return placeOrderRepo.save(payAndPlaceOrder);
    }
}

package com.example.ecommercepurchase.Respository;

import com.example.ecommercepurchase.model.PayAndPlaceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceOrderRepo extends JpaRepository<PayAndPlaceOrder,Long> {
}

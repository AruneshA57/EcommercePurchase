package com.example.ecommercepurchase.Respository;

import com.example.ecommercepurchase.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}

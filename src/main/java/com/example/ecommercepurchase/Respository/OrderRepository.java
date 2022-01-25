package com.example.ecommercepurchase.Respository;

import com.example.ecommercepurchase.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    Boolean existsOrderById(Long id);
    Order getOrderById(Long id);
    List<Order> getOrdersByUserId(Long id);
}

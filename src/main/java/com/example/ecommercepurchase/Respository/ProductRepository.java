package com.example.ecommercepurchase.Respository;

import com.example.ecommercepurchase.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteProductByProductId(Long productId);
    Product getProductByProductId(Long productId);
}

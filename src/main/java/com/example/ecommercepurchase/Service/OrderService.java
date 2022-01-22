package com.example.ecommercepurchase.Service;

import com.example.ecommercepurchase.Respository.OrderRepository;
import com.example.ecommercepurchase.Respository.ProductRepository;
import com.example.ecommercepurchase.Respository.UserRepository;
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

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }



    public List<Order> getAll(){
        return orderRepository.findAll();
    }



    public Order addOrder(Order order){
        Product product = productRepository.getProductByProductId(order.getProductId());

        order.setTotalPrice(product.getProductCost()* order.getQuantity());
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
}

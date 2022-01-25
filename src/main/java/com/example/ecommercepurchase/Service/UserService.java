package com.example.ecommercepurchase.Service;


import com.example.ecommercepurchase.Respository.OrderRepository;
import com.example.ecommercepurchase.Respository.UserRepository;
import com.example.ecommercepurchase.model.Order;
import com.example.ecommercepurchase.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    @Autowired
    public UserService(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }


    //********* PostMapping Adding user to the database *********//

    public User addUser(User user){
        return userRepository.save(user);
    }

    //********* Get product/s from the database **********//

    public User getUser(Long userId) {
       return userRepository.getUserByUserId(userId);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //********* update product from the database *********//

    public User updateUser(User user){
        return userRepository.save(user);
    }




    //********* delete product/s from the database *********//


    public void delete(Long userId){
        userRepository.deleteUserByUserId(userId);
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }


    public List<User> getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }

    public List<Order> getOrders(Long id){
        return orderRepository.getOrdersByUserId(id);
    }
}

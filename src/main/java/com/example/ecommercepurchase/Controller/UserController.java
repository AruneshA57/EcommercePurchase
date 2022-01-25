package com.example.ecommercepurchase.Controller;

import com.example.ecommercepurchase.Service.OrderService;
import com.example.ecommercepurchase.Service.UserService;

import com.example.ecommercepurchase.model.Order;
import com.example.ecommercepurchase.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public UserController(UserService userService, OrderService orderService) {
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id")Long id){
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getByName/{userName}")
    public ResponseEntity<List<User>> getByName(@PathVariable("userName") String userName){
        List<User> users = userService.getUserByUserName(userName);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User addUser = userService.addUser(user);
        return new ResponseEntity<>(addUser,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        userService.deleteAll();
    }

    @GetMapping("/getOrders/{id}")
    public ResponseEntity<List<Order>> getOrder(@PathVariable("id") Long id){
        Long uId = orderService.getOrder(id).getUserId();
        List<Order> orders = userService.getOrders(uId);
        return new ResponseEntity<>(orders,HttpStatus.OK);
    }

}

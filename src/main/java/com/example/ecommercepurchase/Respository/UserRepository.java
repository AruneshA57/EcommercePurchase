package com.example.ecommercepurchase.Respository;

import com.example.ecommercepurchase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUserId(Long userId);
    void deleteUserByUserId(Long userId);
    List<User> getUserByUserName(String userName);


}

package com.example.Java_Projekt.Services;

import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> fetchUsersList() {
        return userRepository.findAll();
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}

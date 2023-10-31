package com.example.Java_Projekt.Services;

import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> fetchUsersList() {
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }
}

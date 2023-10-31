package com.example.Java_Projekt.Controllers;

import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("User")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping("get-user/{id}")
    public Optional<User> fetchUser(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @DeleteMapping("/{id}")
    public String deleteUserById(Long id){
        userService.deleteUserById(id);
        return "User deleted successfully";
    }
}

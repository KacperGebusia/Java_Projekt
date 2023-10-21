package com.example.Java_Projekt.Controllers;

import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> fetchUsersList(){
        return userService.fetchUsersList();
    }
    @DeleteMapping("/{id}")
    public String deleteUserById(Long id){
        userService.deleteUserById(id);
        return "User deleted successfully";
    }
}

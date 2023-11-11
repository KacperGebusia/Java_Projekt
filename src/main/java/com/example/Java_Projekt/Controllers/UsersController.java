package com.example.Java_Projekt.Controllers;

import com.example.Java_Projekt.Models.Requests.RegisterRequest;
import com.example.Java_Projekt.Models.Requests.UserDTO;
import com.example.Java_Projekt.Models.Responses.MessageResponse;
import com.example.Java_Projekt.Models.User;
import com.example.Java_Projekt.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @GetMapping("get-users")
    public List<User> fetchUserList(){
        return userService.getUsersList();
    }
    @DeleteMapping("/{id}")
    public String deleteUserById(Long id){
        userService.deleteUserById(id);
        return "User deleted successfully";
    }
    @PutMapping("edit")
    public ResponseEntity<?> Edit(@RequestBody UserDTO request, Long id){
        MessageResponse response = userService.EditUser(request, id);
        if(response.getStatusCode() == 400){
            return ResponseEntity.badRequest().body(response.getMessage());
        }
        return ResponseEntity.ok().body(response.getMessage());
    }
}

package com.example.Java_Projekt.Controllers;

import com.example.Java_Projekt.Models.Requests.LoginRequest;
import com.example.Java_Projekt.Models.Requests.RegisterRequest;
import com.example.Java_Projekt.Models.Responses.JwtResponse;
import com.example.Java_Projekt.Models.Responses.MessageResponse;
import com.example.Java_Projekt.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Account")
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
public class AccountController {
    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("register")
    public ResponseEntity<?> Register(@RequestBody RegisterRequest request){
        MessageResponse response = accountService.Signup(request);
        if(response.getStatusCode() == 400){
            return ResponseEntity.badRequest().body(response.getMessage());
        }
        return ResponseEntity.ok().body(response.getMessage());
    }
    @PostMapping("login")
    public ResponseEntity<?> Login(@RequestBody LoginRequest request){
        JwtResponse response = accountService.SignIn(request);
        return ResponseEntity.ok(response);
    }
}

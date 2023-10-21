package com.example.Java_Projekt.Controllers;

import com.example.Java_Projekt.Models.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("get-users")
    public String Get(){
        User user =  new User("Bartłomiej","Głuszczak","haslo");
        return user.FirstName;
    }
}

package com.example.Java_Projekt.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @GetMapping("TestowyGet")
    public String Get(){
        return "TEST";
    }
}

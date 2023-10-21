package com.example.Java_Projekt.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class User {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;
    public String FirstName;
    public String LastName;
    public String Password;

    public User(String firstName, String lastName, String password) {
        FirstName = firstName;
        LastName = lastName;
        Password = password;
    }
}

package com.example.Java_Projekt.Exceptions;

public class UsernameNotFoundException  extends RuntimeException {
    public UsernameNotFoundException() {
        super("Username not found.");
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
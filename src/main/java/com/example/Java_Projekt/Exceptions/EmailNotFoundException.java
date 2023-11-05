package com.example.Java_Projekt.Exceptions;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException() {
        super("User with email not found.");
    }

    public EmailNotFoundException(String message) {
        super(message);
    }
}
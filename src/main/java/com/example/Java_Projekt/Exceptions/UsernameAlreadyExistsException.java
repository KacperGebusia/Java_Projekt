package com.example.Java_Projekt.Exceptions;

public class UsernameAlreadyExistsException extends RuntimeException {
    public UsernameAlreadyExistsException() {
        super("Username already exists.");
    }

    public UsernameAlreadyExistsException(String message) {
        super(message);
    }
}

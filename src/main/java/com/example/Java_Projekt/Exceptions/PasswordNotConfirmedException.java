package com.example.Java_Projekt.Exceptions;

public class PasswordNotConfirmedException extends RuntimeException {
    public PasswordNotConfirmedException() {
        super("Given passwords are not the same.");
    }

    public PasswordNotConfirmedException(String message) {
        super(message);
    }
}

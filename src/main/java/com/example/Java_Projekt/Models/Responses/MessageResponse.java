package com.example.Java_Projekt.Models.Responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private String message;
    private int statusCode;

    public void setMessage(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
package com.example.Java_Projekt.Models.Responses;

public class MessageResponse {
    private String message;
    private Integer statusCode;

    public MessageResponse() {
    }

    public MessageResponse(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message, Integer statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
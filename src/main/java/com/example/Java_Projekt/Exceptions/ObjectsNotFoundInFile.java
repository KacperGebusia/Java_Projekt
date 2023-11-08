package com.example.Java_Projekt.Exceptions;

public class ObjectsNotFoundInFile extends Exception {
    public ObjectsNotFoundInFile() {
        super("No objects found in the file.");
    }

    public ObjectsNotFoundInFile(String message) {
        super(message);
    }
}
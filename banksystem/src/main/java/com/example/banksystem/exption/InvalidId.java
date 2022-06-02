package com.example.banksystem.exption;

public class InvalidId extends RuntimeException{

    public InvalidId(String message) {
        super(message);
    }
}

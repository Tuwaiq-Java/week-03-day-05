package com.example.bankmanagementsystem.execption;

public class InvalidIdException extends RuntimeException {
    public InvalidIdException(String msg){
        super(msg);
    }
}

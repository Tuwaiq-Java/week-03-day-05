package com.example.banksystem.advice;

import com.example.banksystem.DTO.API;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Advicecontroller {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> handleException(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(500).body(new API("SERVER ERROR !",500));
    }

}

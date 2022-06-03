package com.example.bankmanagementsystem.advice;

import com.example.bankmanagementsystem.DOT.API;
import com.example.bankmanagementsystem.execption.BalanceException;
import com.example.bankmanagementsystem.execption.InvalidIdException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<API> handleExeption(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(500).body(new API("SERVER ERROR !",500));
    }


    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<API> handleDataIntegrity(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
        return ResponseEntity.status(400).body(new API(message,400));
    }

    @ExceptionHandler(value = BalanceException.class)
    public ResponseEntity<API> handleDataIntegrity(BalanceException balanceException){
        String message=balanceException.getMessage();
        return ResponseEntity.status(400).body(new API(message,400));
    }
}

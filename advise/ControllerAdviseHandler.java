package com.example.bankmanagement.advise;

import com.example.bankmanagement.dto.ApiResponce;
import com.example.bankmanagement.exceptions.InvalidIdExceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdviseHandler {
    Logger logger = LoggerFactory.getLogger(ControllerAdviseHandler.class);
    @ExceptionHandler(value = InvalidIdExceptions.class)
    public ResponseEntity<ApiResponce> handleException(InvalidIdExceptions idExceptions){
        String message = idExceptions.getMessage();
        logger.info(message);
        return ResponseEntity.status(400).body(new ApiResponce(message,400));
    }
}

package com.example.bankw3d5redb.Advice;


import com.example.bankw3d5redb.DTO.Api;
import com.example.bankw3d5redb.Exceptions.InvalidIdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceHandler {

    Logger logger = LoggerFactory.getLogger(ControllerAdviceHandler.class);
    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity<Api> handleIdException(InvalidIdException invalidIdException){
      logger.error("id issue");
        logger.trace("");
        String message = invalidIdException.getMessage();

        return ResponseEntity.status(400).body(new Api(message,400));

    }



}

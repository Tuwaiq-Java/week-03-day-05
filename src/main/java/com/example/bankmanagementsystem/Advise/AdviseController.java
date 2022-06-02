package com.example.bankmanagementsystem.Advise;

import com.example.bankmanagementsystem.DTO.API;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdviseController
{

    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<API> handleDataIntegrity(NullPointerException nullPointerException)
    {
        String message = nullPointerException.getCause().getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new API(message, 500));

    }


}

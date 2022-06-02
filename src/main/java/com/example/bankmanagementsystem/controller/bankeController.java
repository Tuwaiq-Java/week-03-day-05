package com.example.bankmanagementsystem.controller;

import com.example.bankmanagementsystem.DTO.API;
import com.example.bankmanagementsystem.Model.Bank;
import com.example.bankmanagementsystem.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bank")
@RequiredArgsConstructor

public class bankeController {


    private final BankService bankService;

    @GetMapping
    public ResponseEntity<List<Bank>> getBank() {
        List<Bank> banks = bankService.getBank();
        return ResponseEntity.status(HttpStatus.OK).body(banks);


    }

    @PostMapping("/add")
    public ResponseEntity addBank(@RequestBody Bank bank) {
        bankService.addBank(bank);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Customer added !", 201));
    }






}




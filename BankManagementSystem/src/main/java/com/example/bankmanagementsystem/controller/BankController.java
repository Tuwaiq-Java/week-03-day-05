package com.example.bankmanagementsystem.controller;

import com.example.bankmanagementsystem.DOT.API;
import com.example.bankmanagementsystem.model.Bank;
import com.example.bankmanagementsystem.service.BankService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/bank")
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;
    Logger logger = LoggerFactory.getLogger(BankController.class);

    @GetMapping
    public ResponseEntity<List<Bank>> getBanks(){
        logger.info("Get Banks");
        return ResponseEntity.status(200).body(bankService.getBank());
    }

    @PostMapping
    public ResponseEntity<API> addBank(@RequestBody @Valid Bank bank){
        logger.info("Add Banks");
        bankService.addBank(bank);
        return ResponseEntity.status(201).body(new API("Bank added",201));
    }
}

package com.example.bankw3d5redb.Controller;


import com.example.bankw3d5redb.DTO.Api;
import com.example.bankw3d5redb.DTO.CustomerDetailsDTO;
import com.example.bankw3d5redb.Service.BankService;
import com.example.bankw3d5redb.Service.CustomerDetailsService;
import com.example.bankw3d5redb.Service.CustomersService;
import com.example.bankw3d5redb.model.Bank;
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
    private final CustomerDetailsService detailsService;
    
    Logger logger = LoggerFactory.getLogger(BankController.class);


    @GetMapping
    public ResponseEntity<List<Bank>> getBank(){
        logger.info("User Request ( Get)");

        return ResponseEntity.status(200).body(bankService.getBank());

    }


    @PostMapping
    public ResponseEntity<Api> addBank(@RequestBody @Valid Bank bank){

        logger.info("adding bank");
        logger.trace("");
        bankService.addBank(bank);
        return ResponseEntity.status(201).body(new Api("new bank added",201));
    }









}

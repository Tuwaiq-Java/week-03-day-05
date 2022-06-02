package com.example.bankmanagement.controller;

import com.example.bankmanagement.dto.ApiResponce;
import com.example.bankmanagement.model.Bank;
import com.example.bankmanagement.service.BankService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/bank")
@AllArgsConstructor
public class BankController {
    private final BankService bankService;
    Logger logger = LoggerFactory.getLogger(BankController.class);

    @GetMapping
    public List<Bank> getBank(){
        logger.info("get All Banks");
        return bankService.getBank();
    }
    @PostMapping
    public ResponseEntity<ApiResponce> addBank(@RequestBody @Valid Bank bank){
        bankService.addBank(bank);
        logger.info("Post All Banks");
        return ResponseEntity.status(201).body(new ApiResponce("request Valid :)",201));
    }
    @GetMapping("/{id}")
    public ResponseEntity getBankId(@PathVariable Long id){
        logger.info("get getBank Id");
        return ResponseEntity.status(201).body(bankService.getBankId(id));
    }
    @PostMapping("customer-bank/{bank_id}/{customer_id}")
    public ResponseEntity addCustomerBank(@PathVariable Long bank_id,@PathVariable Long customer_id ){
        logger.info("Post Customer Banks");
        bankService.addCustomerBank(bank_id,customer_id);
        return ResponseEntity.status(201).body(new ApiResponce("request Valid :)",201));
    }

}

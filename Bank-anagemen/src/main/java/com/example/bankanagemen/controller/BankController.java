package com.example.bankanagemen.controller;

import com.example.bankanagemen.DTO.Api;
import com.example.bankanagemen.model.Bank;
import com.example.bankanagemen.model.Customer;
import com.example.bankanagemen.serivce.BankService;
import com.example.bankanagemen.serivce.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/bank")
@RequiredArgsConstructor
public class BankController {
Logger logger=LoggerFactory.getLogger(BankController.class);
    private final BankService bankService;


    @GetMapping
    public ResponseEntity<List<Bank>> getBank(){
        logger.info("get bank");

       return ResponseEntity.status(200).body(bankService.getBank());
    }
    @PostMapping

    public ResponseEntity<Api> addCustomer(@RequestBody Bank bank){

        bankService.addBank(bank);
        return ResponseEntity.status(201).body(new Api("Bank  added",201));
    }

    @PostMapping("/addcustmerTobank/{cid}/{bid}")
    public ResponseEntity<Api> addcustmerTobank(@PathVariable Integer cid,@PathVariable Integer bid){

        bankService.addCustomerTobank(cid,bid);
        return ResponseEntity.status(201).body(new Api("c add to bank  added",201));
    }
}

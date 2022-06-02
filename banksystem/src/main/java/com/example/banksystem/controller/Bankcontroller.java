package com.example.banksystem.controller;

import com.example.banksystem.DTO.API;
import com.example.banksystem.model.Bank;
import com.example.banksystem.model.Customer;
import com.example.banksystem.service.Bankservice;
import com.example.banksystem.service.Customerservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/bank")
public class Bankcontroller {

    private final Bankservice bankservice;
    Logger logger= LoggerFactory.getLogger(Bankcontroller.class);




@GetMapping("/getbanks")
    public ResponseEntity getbanks() {
        return ResponseEntity.status(200).body(bankservice.getbank());}



@GetMapping("check/{id}")
    public ResponseEntity<API> checkbankid(@PathVariable Integer id){
    bankservice.checkbankid(id);
        return ResponseEntity.status(200).body(new API("Valid bank",200));}




    @GetMapping("/getbyid/{id}")
    public ResponseEntity getbankById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(bankservice.getbankById(id));}



    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody @Valid Bank bank){
        bankservice.addbank(bank);
        logger.info("add new bank");
        return ResponseEntity.status(200).body("bank is added..");
    }
}

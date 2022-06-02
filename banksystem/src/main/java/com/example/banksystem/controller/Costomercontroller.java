package com.example.banksystem.controller;

import com.example.banksystem.DTO.API;
import com.example.banksystem.DTO.CDetailsDTO;
import com.example.banksystem.DTO.CustomerDTO;
import com.example.banksystem.model.Customer;
import com.example.banksystem.service.Customerservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class Costomercontroller {

    private final Customerservice customerservice;
    Logger logger= LoggerFactory.getLogger(Costomercontroller.class);




@GetMapping("/getcustomer")
    public ResponseEntity getcustomer() {
        return ResponseEntity.status(200).body(customerservice.getcustomer());}




    @GetMapping("/getbyid/{id}")
    public ResponseEntity getcustomerById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(customerservice.getcustomerById(id));}



    @PostMapping("/add/{id}")
    public ResponseEntity<String> addcustomer(@PathVariable Integer id ,@RequestBody @Valid Customer customer){
        customerservice.addcustomer(id,customer);
        logger.info("add new customer");
        return ResponseEntity.status(200).body("customer is added..");
    }

    @PostMapping ("/addcdetails")
    public ResponseEntity addcdetails(@RequestBody @Valid CDetailsDTO cdd){
    customerservice.addcdetails(cdd);
    return ResponseEntity.status(200).body(new API("customer is added",200));
    }
}

package com.example.bankmanagementsystem.controller;

import com.example.bankmanagementsystem.DOT.API;
import com.example.bankmanagementsystem.model.Bank;
import com.example.bankmanagementsystem.model.Customer;
import com.example.bankmanagementsystem.service.BankService;
import com.example.bankmanagementsystem.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor

public class CustomerController {

    private final CustomerService customerService;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        logger.info("Get Customers");
        return ResponseEntity.status(200).body(customerService.getCustomers());
    }

    @PostMapping
    public ResponseEntity<API> addCustomer(@RequestBody @Valid Customer customer){
        logger.info("Add Customers");
        customerService.addCustomer(customer);
        return ResponseEntity.status(201).body(new API("Customer added",201));
    }
    
    
}

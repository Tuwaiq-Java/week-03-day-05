package com.example.bankmanagementsystem.controller;

import com.example.bankmanagementsystem.DOT.API;
import com.example.bankmanagementsystem.model.Customer;
import com.example.bankmanagementsystem.model.CustomerDetails;
import com.example.bankmanagementsystem.service.CustomerDetailsService;
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
@RequestMapping("api/v1/customerdetails")
@RequiredArgsConstructor
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;

    Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getCustomersDetails(){
        logger.info("Get Customers Details");
        return ResponseEntity.status(200).body(customerDetailsService.getCustomersDetails());
    }

    @PostMapping
    public ResponseEntity<API> addCustomerDetails(@RequestBody @Valid CustomerDetails customerDetails){
        logger.info("Add Customers Details");
        customerDetailsService.addCustomerDetails(customerDetails);
        return ResponseEntity.status(201).body(new API("Customer details added",201));
    }

    @GetMapping("withdraw/{id}/{amount}")
    public ResponseEntity<API> withdraw(@PathVariable Integer id,@PathVariable Double amount){
        logger.info("withdraw");
        customerDetailsService.withdraw(id,amount);
        return ResponseEntity.status(201).body(new API("The operation was a success ",201));
    }

    @GetMapping("deposit/{id}/{amount}")
    public ResponseEntity<API> deposit(@PathVariable Integer id,@PathVariable Double amount){
        logger.info("deposit");
        customerDetailsService.deposit(id,amount);
        return ResponseEntity.status(201).body(new API("The operation was a success ",201));
    }
}

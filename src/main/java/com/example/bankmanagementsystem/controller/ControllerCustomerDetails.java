package com.example.bankmanagementsystem.controller;

import com.example.bankmanagementsystem.DTO.API;
import com.example.bankmanagementsystem.Model.Bank;
import com.example.bankmanagementsystem.Model.CustomerDetails;
import com.example.bankmanagementsystem.service.CustomerDetailsService;
import com.example.bankmanagementsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/customerDetails")
@RequiredArgsConstructor
public class ControllerCustomerDetails {

    private CustomerDetailsService customerDetailsService;


    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getCustomerDetails() {
        List<CustomerDetails> customerDetails = customerDetailsService.getCustomerDetails();
        return ResponseEntity.status(HttpStatus.OK).body(customerDetails);


    }

    @PostMapping("/add")
    public ResponseEntity addCustomerDetails(@RequestBody CustomerDetails customerDetails) {
        customerDetailsService.addCustomerDetails(customerDetails);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Customer added !", 201));
    }


}
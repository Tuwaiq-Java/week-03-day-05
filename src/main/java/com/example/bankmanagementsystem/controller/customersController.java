package com.example.bankmanagementsystem.controller;

import com.example.bankmanagementsystem.DTO.API;
import com.example.bankmanagementsystem.Model.Customers;
import com.example.bankmanagementsystem.service.CustomerDetailsService;
import com.example.bankmanagementsystem.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/ customer")
@RequiredArgsConstructor

public class customersController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customers>> getCustomers() {
        List<Customers> customers = customerService.getCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customers);


    }
    @PostMapping("/add")
    public ResponseEntity addCustomers(@RequestBody Customers customers) {
        customerService.addCustomers(customers);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Customer added !", 201));
    }



}

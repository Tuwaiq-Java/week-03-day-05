package com.example.bankanagemen.controller;

import com.example.bankanagemen.DTO.Api;
import com.example.bankanagemen.DTO.CustomerDetailsDTO;
import com.example.bankanagemen.model.Customer;
import com.example.bankanagemen.model.CustomerDetails;
import com.example.bankanagemen.serivce.CustomerService;
import com.example.bankanagemen.serivce.CustomersDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> getCustomer(){

       return ResponseEntity.status(200).body(customerService.getCustomer());
    }
@PostMapping
    public ResponseEntity<Api> addCustomer(@RequestBody Customer customer){

        customerService.addCustomer(customer);
        return ResponseEntity.status(201).body(new Api("Customer  added",201));
    }
    @PostMapping("details")
    public ResponseEntity addCustomerDetails(@RequestBody CustomerDetailsDTO cd){

        customerService.addCustomerDetails(cd);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Customer added !",201));
    }
}

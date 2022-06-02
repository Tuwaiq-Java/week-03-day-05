package com.example.bankmanagement.controller;

import com.example.bankmanagement.dto.ApiResponce;
import com.example.bankmanagement.dto.CustomerDetailsDTO;
import com.example.bankmanagement.model.Customers;
import com.example.bankmanagement.service.CustomersService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class CustomersController {
    private final CustomersService customersService;
    Logger logger = LoggerFactory.getLogger(CustomersController.class);

    @GetMapping
    public List<Customers> getCustomer(){
        logger.info("get all Customer");
        return customersService.getCustomer();
    }
    @PostMapping
    public ResponseEntity<ApiResponce> addCustomer(@RequestBody @Valid Customers customers){
        customersService.addCustomer(customers);
        logger.info("post all Customer");
        return ResponseEntity.status(201).body(new ApiResponce("request Valid :)",201));
    }
    @PostMapping("/details")
    public ResponseEntity<ApiResponce> addCustomerDetails(@RequestBody @Valid CustomerDetailsDTO customersDTO){
       Customers customers = customersService.addCustomerDetails(customersDTO);
        return ResponseEntity.status(201).body(new ApiResponce("request Valid :)",201));
    }
    @GetMapping("/{id}")
    public ResponseEntity getCustomerId(@PathVariable Long id){
        logger.info("get getCustomer Id");
        return ResponseEntity.status(200).body(customersService.getCustomerId(id));
    }
}

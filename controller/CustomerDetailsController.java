package com.example.bankmanagement.controller;

import com.example.bankmanagement.dto.ApiResponce;
import com.example.bankmanagement.model.CustomerDetails;
import com.example.bankmanagement.service.CustomerDetailsService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer-details")
@AllArgsConstructor
public class CustomerDetailsController {
    private final CustomerDetailsService customerDS;
    Logger logger = LoggerFactory.getLogger(CustomerDetailsController.class);

    @GetMapping
    public List<CustomerDetails> getCustomerDetails(){
        logger.info("get all CustomerDetails");
        return customerDS.getCustomerDetails();
    }
    @PostMapping
    public ResponseEntity<ApiResponce> addCustomerDetails(@RequestBody @Valid CustomerDetails customerDetails){
        customerDS.addCustomerDetails(customerDetails);
        logger.info("post all CustomerDetails");
        return ResponseEntity.status(201).body(new ApiResponce("request Valid :)",201));
    }
}

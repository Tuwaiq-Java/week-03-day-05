package com.example.bankanagemen.controller;

import com.example.bankanagemen.DTO.Api;
import com.example.bankanagemen.model.CustomerDetails;
import com.example.bankanagemen.serivce.CustomersDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customersdetail")
@RequiredArgsConstructor
public class CustomersDetailController {

    private final CustomersDetailService customersDetailService;


    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getCustomersDetail(){

       return ResponseEntity.status(200).body(customersDetailService.getCustomersDetail());
    }
    @PostMapping
    public ResponseEntity<Api> addCustomerDetail(@RequestBody CustomerDetails customerDetails){

        customersDetailService.addCustomerDetail(customerDetails);
        return ResponseEntity.status(201).body(new Api("Customer Details added",201));
    }

    @PostMapping("/withdraw/{customerid}/{amount}")
    public ResponseEntity<Api> withdraw(@PathVariable Integer customerid ,@PathVariable Integer amount ){
       customersDetailService.withdraw(customerid,amount);
        return ResponseEntity.status(201).body(new Api("The process done",201));
    }

    @PostMapping("/deposit/{customerid}/{amount}")
    public ResponseEntity<Api>deposit(@PathVariable Integer customerid ,@PathVariable Integer amount ){
        customersDetailService.deposit(customerid,amount);
        return ResponseEntity.status(201).body(new Api("The deposit process done",201));
    }

}

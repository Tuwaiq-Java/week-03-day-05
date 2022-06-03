package com.example.bankw3d5redb.Controller;


import com.example.bankw3d5redb.DTO.Api;
import com.example.bankw3d5redb.Service.CustomerDetailsService;
import com.example.bankw3d5redb.model.OneToOne.CustomerDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customerdet")
@RequiredArgsConstructor
public class CustomerDetailsController {

    private final CustomerDetailsService customerDetailsService;




    @GetMapping
    public ResponseEntity<List<CustomerDetails>> getCustomerDets(){

        return ResponseEntity.status(200).body(customerDetailsService.getCustomerDets());

    }



    @PostMapping
    public ResponseEntity<Api> addCustomerDets(@RequestBody @Valid CustomerDetails customerDetails){


        customerDetailsService.addCustomerDets(customerDetails);
        return ResponseEntity.status(201).body(new Api("New Customer Details is added" ,201));





    }
}

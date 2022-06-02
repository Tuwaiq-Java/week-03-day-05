package com.example.banksystem.controller;

import com.example.banksystem.model.Customer;
import com.example.banksystem.model.CustomerDetails;
import com.example.banksystem.service.CDservice;
import com.example.banksystem.service.Customerservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cdetails")
public class CDcontroller {

    private final CDservice cDservice;
    Logger logger= LoggerFactory.getLogger(CDcontroller.class);




@GetMapping("/getcdetails")
    public ResponseEntity getcdetails() {
        return ResponseEntity.status(200).body(cDservice.getCdetails());}




    @GetMapping("/getbyid/{id}")
    public ResponseEntity getCdetailsById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(cDservice.getCdetailsById(id));}



    @PostMapping("/add")
    public ResponseEntity<String> addCdetails(@RequestBody @Valid CustomerDetails cd){
        cDservice.addCdetails(cd);
        logger.info("add new customer details");
        return ResponseEntity.status(200).body("customer is added..");
    }

    @PostMapping("withdrow/{id}/{amount}")
    public ResponseEntity withrraw(@PathVariable Integer id, @PathVariable Integer amount){
    cDservice.withdrow(id,amount);
        return ResponseEntity.status(200).body("withdraw is good..");
    }
    @PostMapping("deposit/{id}/{amount}")
    public ResponseEntity deposit(@PathVariable Integer id,@PathVariable Integer amount){
        cDservice.withdrow(id,amount);
        return ResponseEntity.status(200).body("deposit is good..");
    }
}

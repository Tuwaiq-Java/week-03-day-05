package com.example.bankw3d5redb.Controller;


import com.example.bankw3d5redb.DTO.Api;
import com.example.bankw3d5redb.DTO.CustomerDetailsDTO;
import com.example.bankw3d5redb.Reopsitory.CustomerDetailsRepository;
import com.example.bankw3d5redb.Reopsitory.CustomerRepository;
import com.example.bankw3d5redb.Service.CustomersService;
import com.example.bankw3d5redb.model.OneToOne.CustomerDetails;
import com.example.bankw3d5redb.model.OneToOne.Customers;
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
public class CustomersController {

    private final CustomersService customersService ;
    private final CustomerRepository customerRepository;
    private final CustomerDetailsRepository customerDetailsRepository;

    Logger logger = LoggerFactory.getLogger(CustomersController.class);

    @GetMapping
    public ResponseEntity<List<Customers>> getCustomers(){
        logger.info("User Request ( Get)");

        return ResponseEntity.status(200).body(customersService.getCustomers());

    }


    @PostMapping
    public ResponseEntity<Api> addCustomer(@RequestBody @Valid Customers customers){

          logger.info("adding customer");
           logger.trace("");
        customersService.addCustomer(customers);
        return ResponseEntity.status(201).body(new Api("new Customer added",201));
    }




    // problems w adding customer details
    @PostMapping("/details")
    public ResponseEntity addCustomerDetails(@RequestBody CustomerDetailsDTO customerDetailsDTO){
        Customers customer=customerRepository.findById(customerDetailsDTO.getCustomerId()).get();
        CustomerDetails customerDetails=new CustomerDetails(customerDetailsDTO.getCustomerId(),customerDetailsDTO.getAge(), customerDetailsDTO.getBalance(),customer);
        customer.setCustomerDetails(customerDetails);

        customerDetailsRepository.save(customerDetails);
        return ResponseEntity.status(201).body(new Api("Customer dets added !",201));
    }
















    @PutMapping("/withdraw")
    private ResponseEntity<CustomerDetailsDTO> withdraws(@RequestBody CustomerDetailsDTO customerDetailsDTO){
        return ResponseEntity.status(200).body(customersService.withdraws(customerDetailsDTO));

    }



    @PutMapping("/deposit")
    private ResponseEntity<CustomerDetailsDTO> deposits (@RequestBody CustomerDetailsDTO customerDetailsDTO){
        return ResponseEntity.status(200).body(customersService.deposits(customerDetailsDTO));

    }















}

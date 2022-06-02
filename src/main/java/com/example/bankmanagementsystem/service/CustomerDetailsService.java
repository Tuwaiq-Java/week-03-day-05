package com.example.bankmanagementsystem.service;

import com.example.bankmanagementsystem.Model.CustomerDetails;
import com.example.bankmanagementsystem.Repository.CustomerDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CustomerDetailsService {
    private final CustomerDetailsRepository customerDetailsRepository ;


    public List<CustomerDetails> getCustomerDetails() {
        return customerDetailsRepository.findAll();

    }

    public void addCustomerDetails(CustomerDetails customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }



}




package com.example.bankmanagementsystem.service;

import com.example.bankmanagementsystem.Model.Customers;
import com.example.bankmanagementsystem.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service

public class CustomerService {
private  final CustomerRepository customerRepository ;
    public List<Customers> getCustomers() {
        return customerRepository.findAll();
    }

    public void addCustomers(Customers customers) {
        customerRepository.save(customers);

    }
}

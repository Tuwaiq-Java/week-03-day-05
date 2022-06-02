package com.example.bankmanagement.service;

import com.example.bankmanagement.dto.CustomerDetailsDTO;
import com.example.bankmanagement.exceptions.InvalidIdExceptions;
import com.example.bankmanagement.model.CustomerDetails;
import com.example.bankmanagement.model.Customers;
import com.example.bankmanagement.repository.CustomerDetailsRepository;
import com.example.bankmanagement.repository.CustomersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomersService {
    private final CustomersRepository customersRepository;
    private final CustomerDetailsRepository customerDetailsRepository;
    public List<Customers> getCustomer() {
        return customersRepository.findAll();
    }
    public boolean addCustomer(Customers customers) {
        customersRepository.save(customers);
        return true;
    }

    public Customers addCustomerDetails(CustomerDetailsDTO customersDTO) {
        Customers customer=customersRepository.findById(customersDTO.getCustomerId()).get();
        CustomerDetails customerDetails=new CustomerDetails(null,customersDTO.getAge(),customersDTO.getBalance(),customer);
        customer.setCustomerDetails(customerDetails);

        customerDetailsRepository.save(customerDetails);
        return customer;
    }
    public Customers getCustomerId(Long id) {
        Optional<Customers> customers = customersRepository.findById(id);
        if (customers.isEmpty()){
            throw new InvalidIdExceptions("Invalid ID");
        }
        return customers.get();
    }
}

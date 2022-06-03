package com.example.bankmanagementsystem.service;

import com.example.bankmanagementsystem.execption.InvalidIdException;
import com.example.bankmanagementsystem.model.Bank;
import com.example.bankmanagementsystem.model.Customer;
import com.example.bankmanagementsystem.model.CustomerDetails;
import com.example.bankmanagementsystem.repo.BankRepo;
import com.example.bankmanagementsystem.repo.CustomerDetailsRepo;
import com.example.bankmanagementsystem.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final CustomerDetailsRepo customerDetailsRepo;
    private final BankRepo bankRepo;
    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    public void addCustomer(Customer customer){
        customerRepo.save(customer);
    }

    public void addDetails(Integer customerid,Integer customerDetailsid)
    {
        Optional<Customer> customer=customerRepo.findById(customerid);
        if(customer.isEmpty()) {
            throw new InvalidIdException("Customer id not found !");
        }
        Optional<CustomerDetails>customerDetails=customerDetailsRepo.findById(customerDetailsid);
        if(customerDetails.isEmpty()){
            throw new InvalidIdException("Customer id not found !");
        }
        customer.get().setCustomerDetails(customerDetails.get());
        customerRepo.save(customer.get());
    }

    public void addBanktoCustomer(Integer customerid,Integer bankid)
    {
        Optional<Customer>customer=customerRepo.findById(customerid);
        if(customer.isEmpty()){
            throw new InvalidIdException("Customer id not found !");
        }
        Optional<Bank>bank=bankRepo.findById(bankid);
        if(bank.isEmpty()){
            throw new InvalidIdException("Customer id not found !");}
        customer.get().getBanks().add(bank.get());
        customerRepo.save(customer.get());
    }
}

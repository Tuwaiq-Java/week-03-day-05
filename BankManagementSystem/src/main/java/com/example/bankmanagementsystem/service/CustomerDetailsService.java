package com.example.bankmanagementsystem.service;

import com.example.bankmanagementsystem.execption.BalanceException;
import com.example.bankmanagementsystem.execption.InvalidIdException;
import com.example.bankmanagementsystem.model.Customer;
import com.example.bankmanagementsystem.model.CustomerDetails;
import com.example.bankmanagementsystem.repo.CustomerDetailsRepo;
import com.example.bankmanagementsystem.repo.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerDetailsService {
    private final CustomerDetailsRepo customerDetailsRepo;

    public List<CustomerDetails> getCustomersDetails(){
        return customerDetailsRepo.findAll();
    }

    public void addCustomerDetails(CustomerDetails customerDetails){
        customerDetailsRepo.save(customerDetails);
    }

    public void withdraw(Integer id,Double amount){
        Optional<CustomerDetails> customerDetails= customerDetailsRepo.findById(id);
        if(customerDetails.isEmpty()){
            throw new InvalidIdException(" customer id is not found !");
        }
        if(customerDetails.get().getBalance()<amount){
            throw new BalanceException("Your balance is not enough ");
        }
        customerDetails.get().setBalance(customerDetails.get().getBalance()-amount);
        customerDetailsRepo.save(customerDetails.get());
//        customerRepo.findById(id).orElseThrow(
//                ()->new InvalidIdException("Invalid id"));
//        CustomerDetails customerDetails= setBalance(customerDetails.getBalance()-amount);

    }

    public void deposit(Integer id,Double amount) {
        Optional<CustomerDetails> customerDetails = customerDetailsRepo.findById(id);
        if (customerDetails.isEmpty()) {
            throw new InvalidIdException(" customer id is not found !");
        }
        customerDetails.get().setBalance(customerDetails.get().getBalance() + amount);
        customerDetailsRepo.save(customerDetails.get());
    }

}

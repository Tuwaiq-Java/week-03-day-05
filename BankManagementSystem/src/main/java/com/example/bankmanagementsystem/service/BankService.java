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

@Service
@RequiredArgsConstructor
public class BankService {
    private final BankRepo bankRepo;


    public List<Bank> getBank(){
        return bankRepo.findAll();
    }

    public void addBank(Bank bank){
        bankRepo.save(bank);
    }
}

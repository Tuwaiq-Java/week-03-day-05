package com.example.banksystem.service;

import com.example.banksystem.Repository.Bankrepo;
import com.example.banksystem.Repository.Customerrepo;
import com.example.banksystem.exption.InvalidId;
import com.example.banksystem.model.Bank;
import com.example.banksystem.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Bankservice {

    private final Bankrepo bankrepo;


    public List<Bank> getbank(){
        return bankrepo.findAll();
    }


    public Bank getbankById(Integer id){
        return bankrepo.findById(id).get();
    }



    public void addbank(Bank bank){
        bankrepo.save(bank);
    }



    public void checkbankid(Integer id) {
        Bank bank=bankrepo.findById(id)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
    }

}

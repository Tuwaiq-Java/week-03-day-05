package com.example.banksystem.service;

import com.example.banksystem.Repository.Bankrepo;
import com.example.banksystem.Repository.CDrepo;
import com.example.banksystem.exption.InvalidId;
import com.example.banksystem.model.Bank;
import com.example.banksystem.model.Customer;
import com.example.banksystem.model.CustomerDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CDservice {

    private final CDrepo cDrepo;


    public List<CustomerDetails> getCdetails() {
        return cDrepo.findAll();
    }


    public CustomerDetails getCdetailsById(Integer id) {
        return cDrepo.findById(id).get();
    }


    public void addCdetails(CustomerDetails cd) {
        cDrepo.save(cd);
    }


    public void withdrow(Integer id, Integer amount) {
        CustomerDetails cd = cDrepo.findById(id)
                .orElseThrow(
                        () -> new InvalidId("Invalid id"));
        if(cd.getBalance()<amount)throw new RuntimeException("balance less than amount");
        cd.setBalance(cd.getBalance()-amount);
        cDrepo.save(cd);
    }

    public void deposit(Integer id, Integer amount) {
        CustomerDetails cd = cDrepo.findById(id)
                .orElseThrow(
                        () -> new InvalidId("Invalid id"));
        cd.setBalance(cd.getBalance()+amount);
        cDrepo.save(cd);
    }
}
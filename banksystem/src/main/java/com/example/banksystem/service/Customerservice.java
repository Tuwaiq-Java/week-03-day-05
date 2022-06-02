package com.example.banksystem.service;

import com.example.banksystem.DTO.API;
import com.example.banksystem.DTO.CDetailsDTO;
import com.example.banksystem.DTO.CustomerDTO;
import com.example.banksystem.Repository.Bankrepo;
import com.example.banksystem.Repository.CDrepo;
import com.example.banksystem.Repository.Customerrepo;
import com.example.banksystem.exption.InvalidId;
import com.example.banksystem.model.Bank;
import com.example.banksystem.model.Customer;
import com.example.banksystem.model.CustomerDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class Customerservice {

    private final Customerrepo customerrepo;
    private final CDrepo cDrepo;
    private final Bankrepo bankrepo;


    public List<Customer> getcustomer() {
        return customerrepo.findAll();
    }


    public Customer getcustomerById(Integer id) {
        return customerrepo.findById(id).get();
    }


    public void addcustomer(Integer bankid,Customer customer) {
      Bank bank=bankrepo.findById(bankid).get();
        Customer customer1=new Customer(bankid,customer.getUsername(),null,bank);
customer.setBank(bank);
        customerrepo.save(customer1);
    }


    public void addcdetails(CDetailsDTO cdd) {
Customer customer=customerrepo.findById(cdd.getCustomerid()).get();
        CustomerDetails cdetails=new CustomerDetails(null,cdd.getAge(),cdd.getBalance(),customer);
        customer.setCustomerDetails(cdetails);
        cDrepo.save(cdetails);}

    public void withdrow(Integer amount){

    }

    public void checkcustomerid(Integer id) {
        Customer students=customerrepo.findById(id)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
    }

}

package com.example.bankmanagement.service;
import com.example.bankmanagement.exceptions.InvalidIdExceptions;
import com.example.bankmanagement.model.Bank;
import com.example.bankmanagement.model.Customers;
import com.example.bankmanagement.repository.BankRepository;
import com.example.bankmanagement.repository.CustomersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BankService {
    private final BankRepository bankRepository;
    private final CustomersRepository customersRepository;

    public List<Bank> getBank() {
        return bankRepository.findAll();
    }
    public boolean addBank(Bank bank) {
        bankRepository.save(bank);
        return true;
    }
    public Bank getBankId(Long id) {
        Optional<Bank> bank=bankRepository.findById(id);
        if (bank.isEmpty()){
           throw new InvalidIdExceptions("Invalid ID");
        }
        return bank.get();
    }
    public void addCustomerBank(Long bank_id, Long customer_id) {
        Optional<Bank> bank=bankRepository.findById(bank_id);
        if (bank.isEmpty()){
            throw new InvalidIdExceptions("Invalid ID");
        }
        Optional<Customers> customers=customersRepository.findById(customer_id);
        if (customers.isEmpty()){
            throw new InvalidIdExceptions("Invalid ID");
        }
        bank.get().getCustomers().add(customers.get());
        bankRepository.save(bank.get());
    }
}

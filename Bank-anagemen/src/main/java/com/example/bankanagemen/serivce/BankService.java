package com.example.bankanagemen.serivce;

import com.example.bankanagemen.excption.InvalidIdException;
import com.example.bankanagemen.model.Bank;
import com.example.bankanagemen.model.Customer;
import com.example.bankanagemen.repositroy.BankRepository;
import com.example.bankanagemen.repositroy.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;
    private final CustomerRepository customerRepository;
    public List<Bank> getBank() {
return bankRepository.findAll();
    }

    public void addBank(Bank bank) {
        bankRepository.save(bank);
    }

    public void addCustomerTobank(Integer costomerId,Integer bankId){
        Customer customer=customerRepository.findById(costomerId).
                orElseThrow(() -> new InvalidIdException("Invild id"));
        Bank bank=bankRepository.findById(bankId).
                orElseThrow(() -> new InvalidIdException("Invild id"));
       customer.setBanks(bank);
      customerRepository.save(customer);



}
}

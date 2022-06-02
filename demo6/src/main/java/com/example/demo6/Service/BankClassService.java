package com.example.demo6.Service;

import com.example.demo6.Model.BankClass;
import com.example.demo6.Repository.BankClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BankClassService {

    private final BankClassRepository bankClassRepository;
    public List<BankClass> getBanks() {
    return bankClassRepository.findAll();
    }

    public void addCustomer(BankClass bankClass) {
        bankClassRepository.save(bankClass);
    }
}

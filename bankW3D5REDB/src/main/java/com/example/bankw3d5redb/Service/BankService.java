package com.example.bankw3d5redb.Service;

import com.example.bankw3d5redb.DTO.CustomerDetailsDTO;
import com.example.bankw3d5redb.Reopsitory.BankRepository;
import com.example.bankw3d5redb.Reopsitory.CustomerDetailsRepository;
import com.example.bankw3d5redb.model.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class BankService {

    private final BankRepository bankRepository;
    private final CustomerDetailsRepository customerDetailsRepository;

    public List<Bank> getBank() {
       return bankRepository.findAll();
    }


    public void addBank(Bank bank){
        bankRepository.save(bank);

    }

}

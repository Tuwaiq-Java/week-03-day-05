package com.example.banksystem.Repository;

import com.example.banksystem.model.Bank;
import com.example.banksystem.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Bankrepo extends JpaRepository<Bank,Integer> {
}

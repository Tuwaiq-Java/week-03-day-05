package com.example.bankmanagement.repository;

import com.example.bankmanagement.model.Bank;
import com.example.bankmanagement.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long> {
}

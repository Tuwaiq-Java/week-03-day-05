package com.example.bankanagemen.repositroy;

import com.example.bankanagemen.model.Bank;
import com.example.bankanagemen.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank,Integer> {
}

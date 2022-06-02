package com.example.banksystem.Repository;

import com.example.banksystem.DTO.CustomerDTO;
import com.example.banksystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Customerrepo extends JpaRepository<Customer,Integer> {
}

package com.example.banksystem.Repository;

import com.example.banksystem.model.Customer;
import com.example.banksystem.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CDrepo extends JpaRepository<CustomerDetails,Integer> {
}

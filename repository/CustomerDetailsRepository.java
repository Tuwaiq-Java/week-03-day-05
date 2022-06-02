package com.example.bankmanagement.repository;

import com.example.bankmanagement.model.CustomerDetails;
import com.example.bankmanagement.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails,Long> {
}

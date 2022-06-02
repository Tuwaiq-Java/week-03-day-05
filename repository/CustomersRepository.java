package com.example.bankmanagement.repository;

import com.example.bankmanagement.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Long> {
    Optional<Customers> findById(Customers id);
}

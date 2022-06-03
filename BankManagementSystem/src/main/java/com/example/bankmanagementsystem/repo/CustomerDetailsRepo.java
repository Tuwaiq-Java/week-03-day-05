package com.example.bankmanagementsystem.repo;

import com.example.bankmanagementsystem.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDetailsRepo extends JpaRepository<CustomerDetails,Integer> {
}

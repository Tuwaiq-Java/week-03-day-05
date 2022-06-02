package com.example.bankanagemen.repositroy;

import com.example.bankanagemen.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersDetailRepository extends JpaRepository<CustomerDetails,Integer> {
}

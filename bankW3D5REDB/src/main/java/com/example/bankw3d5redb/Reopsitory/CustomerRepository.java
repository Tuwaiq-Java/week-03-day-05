package com.example.bankw3d5redb.Reopsitory;


import com.example.bankw3d5redb.model.OneToOne.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customers, Integer> {


}

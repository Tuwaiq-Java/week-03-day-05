package com.example.demo6.Repository;

import com.example.demo6.Model.BankClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankClassRepository extends JpaRepository<BankClass,Integer> {
}

package com.example.demo6.Repository;

import com.example.demo6.Model.CustomerClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerClassRepository extends JpaRepository< CustomerClass,Integer>{
}

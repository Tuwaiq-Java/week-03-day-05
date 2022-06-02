package com.example.demo6.Service;

import com.example.demo6.Model.CustomerClass;
import com.example.demo6.Repository.CustomerClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomersClassService {

    private final CustomerClassRepository customerClassRepository;

    public List<CustomerClass> getClasses() {
        return customerClassRepository.findAll();
    }

    public void addClasses(CustomerClass customerClass) {
        customerClassRepository.save(customerClass);
    }
}


package com.example.bankmanagement.service;
import com.example.bankmanagement.model.CustomerDetails;
import com.example.bankmanagement.repository.CustomerDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class CustomerDetailsService {
    private final CustomerDetailsRepository customerDR;
    public List<CustomerDetails> getCustomerDetails() {
        return customerDR.findAll();
    }
    public boolean addCustomerDetails(CustomerDetails customers) {
        customerDR.save(customers);
        return true;
    }
}

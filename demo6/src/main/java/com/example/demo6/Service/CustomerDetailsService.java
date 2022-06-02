package com.example.demo6.Service;

import com.example.demo6.Model.BankClass;
import com.example.demo6.Model.CustomerDetails;
import com.example.demo6.Repository.CustomerDetailsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerDetailsService {

    private final CustomerDetailsRepository customerDetailsRepository;
    public List<CustomerDetails> getDetails() {
        return customerDetailsRepository.findAll();
    }

    public void addDetails(CustomerDetails customerDetails) {
        customerDetailsRepository.save(customerDetails);
    }

    public Boolean withDrow(Integer customerId, Integer amount) {
        CustomerDetails customerDetails = customerDetailsRepository.findById(customerId).get();

        if (amount <= customerDetails.getBalance() ){
            customerDetails.setBalance(customerDetails.getBalance()-amount);
            updateCustomerDetails(customerDetails);
            return true;
        }
        return false;

    }

    public void deposit(Integer customerId, Integer amount) {
        CustomerDetails customerDetails = getCustomerDetailsByID(customerId);

            customerDetails.setBalance(customerDetails.getBalance()+amount);
            updateCustomerDetails(customerDetails);


    }

    private void updateCustomerDetails(CustomerDetails customerDetails) {

    }

    private CustomerDetails getCustomerDetailsByID(Integer customerId) {
        return customerDetailsRepository.findById(customerId).get();
    }
}


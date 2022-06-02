package com.example.bankanagemen.serivce;

import com.example.bankanagemen.DTO.CustomerDetailsDTO;
import com.example.bankanagemen.model.Customer;
import com.example.bankanagemen.model.CustomerDetails;
import com.example.bankanagemen.repositroy.CustomerRepository;
import com.example.bankanagemen.repositroy.CustomersDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomersDetailRepository customersDetailRepository;

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }


    /*public void addCustomerDetailToCustomer(Integer customerId,Integer customerDid ){

        Customer customer = customerRepository.findById(customerId).
                orElseThrow(() -> new RuntimeException("Customer not found"));
        CustomerDetails customerDetails=customersDetailRepository.findById(customerDid).
                orElseThrow(() -> new RuntimeException("Customer Detail not found"));

      //  if (CollectionUtils.isEmpty((Collection<?>) customer.getCustomerDetails())){

      //      customer.setCustomerDetails(new HashSet<>());
      //  }





    }*/

    public void addCustomerDetails(CustomerDetailsDTO cd) {
        Customer customer = customerRepository.findById(cd.getCustomerId()).get();
        CustomerDetails customerDetails = new CustomerDetails(null, cd.getAge(), cd.getBalance(),customer );
        customer.setCustomerDetails(customerDetails);
        customersDetailRepository.save(customerDetails);

        customersDetailRepository.save(customerDetails);
    }
}
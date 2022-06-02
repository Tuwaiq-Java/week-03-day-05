package com.example.bankanagemen.serivce;

import com.example.bankanagemen.excption.InvalidIdException;
import com.example.bankanagemen.model.CustomerDetails;
import com.example.bankanagemen.repositroy.CustomerRepository;
import com.example.bankanagemen.repositroy.CustomersDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomersDetailService {

    private final CustomersDetailRepository customersDetailRepository;
    private final CustomerRepository customerRepository;
    public List<CustomerDetails> getCustomersDetail()
    {
return customersDetailRepository.findAll();
    }

    public void addCustomerDetail(CustomerDetails customerDetails) {
        customersDetailRepository.save(customerDetails);
    }

    public void withdraw(Integer customerId,Integer amount){
       CustomerDetails customerDetails =customersDetailRepository.findById(customerId).
               orElseThrow(() -> new InvalidIdException("Invild id"));

       if (customerDetails.getBalance()<amount){
           throw new RuntimeException("your balance less than amount ");

       }
        customerDetails.setBalance(customerDetails.getBalance()-amount);
       customersDetailRepository.save(customerDetails);


      //  customerRepository.findById(customerId).orElseThrow(() -> new InvalidIdException("Invild id"));
    }
        public void deposit(Integer customerId,Integer amount){
        CustomerDetails customerDetails =customersDetailRepository.findById(customerId).
                orElseThrow(() -> new InvalidIdException("Invild id"));


        customerDetails.setBalance(customerDetails.getBalance()+amount);
            customersDetailRepository.save(customerDetails);


        //  customerRepository.findById(customerId).orElseThrow(() -> new InvalidIdException("Invild id"));
    }
}

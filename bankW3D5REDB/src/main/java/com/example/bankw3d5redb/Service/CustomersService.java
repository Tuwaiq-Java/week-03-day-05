package com.example.bankw3d5redb.Service;

import com.example.bankw3d5redb.DTO.CustomerDetailsDTO;
import com.example.bankw3d5redb.Reopsitory.CustomerDetailsRepository;
import com.example.bankw3d5redb.Reopsitory.CustomerRepository;
import com.example.bankw3d5redb.model.OneToOne.Customers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomersService {

private final CustomerRepository customerRepository ;
private final CustomerDetailsRepository customerDetailsRepository;


    public List<Customers> getCustomers() {
        return customerRepository.findAll();
    }


    public void addCustomer(Customers customers){
        customerRepository.save(customers);
    }



    public CustomerDetailsDTO withdraws(CustomerDetailsDTO customerDetailsDTO) {
       CustomerDetailsDTO customerDetailsDTO1 = new CustomerDetailsDTO();
       customerDetailsDTO1.getCustomerId();
       Integer customerOldBalance = customerDetailsDTO1.getBalance();
       customerDetailsDTO1.setBalance(customerOldBalance -customerDetailsDTO.getBalance());

       return customerDetailsDTO1;


    }

    public CustomerDetailsDTO deposits(CustomerDetailsDTO customerDetailsDTO) {
        CustomerDetailsDTO customerDetailsDTO1 = new CustomerDetailsDTO();
        customerDetailsDTO1.getCustomerId();
        Integer customerOldBalance = customerDetailsDTO1.getBalance();
        customerDetailsDTO1.setBalance(customerOldBalance -customerDetailsDTO.getBalance());

        return customerDetailsDTO1;








    }


}



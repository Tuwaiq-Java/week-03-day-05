package com.example.bankw3d5redb.Service;

import com.example.bankw3d5redb.Reopsitory.CustomerDetailsRepository;
import com.example.bankw3d5redb.model.OneToOne.CustomerDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CustomerDetailsService {

    CustomerDetailsRepository customerDetailsRepository;




    public List<CustomerDetails> getCustomerDets(){
        return customerDetailsRepository.findAll();

    }


    public void addCustomerDets(CustomerDetails customerDetails){
        customerDetailsRepository.save(customerDetails);
    }

}

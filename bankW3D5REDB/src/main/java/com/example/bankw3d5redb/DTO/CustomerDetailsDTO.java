package com.example.bankw3d5redb.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class CustomerDetailsDTO {

    private Integer customerId; // from class customer
    private String age;
    private Integer balance ;


}

package com.example.bankanagemen.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CustomerDetailsDTO {

    private Integer customerId;
    private Integer age;
    private Integer balance;
}

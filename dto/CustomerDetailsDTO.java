package com.example.bankmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class CustomerDetailsDTO {
    private Long customerId;
    private String username;
    private Integer age;
    private Integer balance;
}

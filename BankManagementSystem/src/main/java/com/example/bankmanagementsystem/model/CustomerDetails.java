package com.example.bankmanagementsystem.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer age;

    @NotNull
    private Double balance;

    @OneToOne(mappedBy = "customerDetails")
    private Customer customer;
}

package com.example.bankmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name is required") @Column(unique = true)
    private String name;

    @ManyToOne
    @JsonIgnore
    private Customer customer;
}

package com.example.banksystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy ="bank",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Customer> customers;

}

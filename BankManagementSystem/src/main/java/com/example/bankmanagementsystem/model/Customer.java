package com.example.bankmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Username is required") @Column(unique = true)
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CustomerDetailsId")
    @JsonIgnore
    private CustomerDetails customerDetails;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Bank> banks;
}

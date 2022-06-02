package com.example.banksystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Customer {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String username;


    @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;

    @ManyToOne
    // @JsonIgnore
    private Bank bank;



}

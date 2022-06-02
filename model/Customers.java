package com.example.bankmanagement.model;

import com.example.bankmanagement.dto.CustomerDetailsDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Customers {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty(message = "username is required")
    private String username;

    @OneToOne(mappedBy ="customers" ,cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;

    @ManyToOne
    @JsonIgnore
    private Bank bank;

    public Customers(CustomerDetailsDTO customersDTO) {
    }
}

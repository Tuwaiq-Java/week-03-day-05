package com.example.bankmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class CustomerDetails {
    @Id
    private Long id;
    @NotNull(message = "age is required")
    private Integer age;
    @NotNull(message = "balance is required")
    private Integer balance;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JsonIgnore
    private Customers customers;
}

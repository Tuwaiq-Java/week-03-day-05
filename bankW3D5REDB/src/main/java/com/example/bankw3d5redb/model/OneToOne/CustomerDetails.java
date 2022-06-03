package com.example.bankw3d5redb.model.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "age is required")
    private String age ;
    @NotNull (message = "balance is required")
    @Positive
    private Integer balance;


    @OneToOne
    @MapsId // it means ignore the id on the cutomerdet n get the id of Customer
    @JoinColumn(name = "customers_id")
    @JsonIgnore // ignore the customer when customer dets called
    private Customers customers;
}

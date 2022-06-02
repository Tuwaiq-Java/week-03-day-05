package com.example.banksystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class CustomerDetails {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
@Column(nullable = false)
    private Integer age;
@Column (nullable = false)
    private Integer balance;


    @OneToOne(cascade  = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;}

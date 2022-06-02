package com.example.bankanagemen.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "The name requrid")
    private String name;

    @ManyToOne
    @JsonIgnore
    private Customer customer;
    @OneToMany(mappedBy = "banks",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Customer> customers;

}

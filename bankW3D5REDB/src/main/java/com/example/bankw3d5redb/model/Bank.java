package com.example.bankw3d5redb.model;


import com.example.bankw3d5redb.model.OneToOne.Customers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "name is required")
    @Size(min = 3)
    private String name;


    @OneToMany(mappedBy = "bank")

    private Set<Customers> customers;



}

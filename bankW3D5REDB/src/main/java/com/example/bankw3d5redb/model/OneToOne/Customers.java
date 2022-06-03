package com.example.bankw3d5redb.model.OneToOne;

import com.example.bankw3d5redb.model.Bank;
import com.example.bankw3d5redb.model.OneToOne.CustomerDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "username is required")
    @Column(unique = true)
    private String username;


    @OneToOne(mappedBy = "customers")
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;



    @ManyToOne
    @JsonIgnore
    private Bank bank ;

}

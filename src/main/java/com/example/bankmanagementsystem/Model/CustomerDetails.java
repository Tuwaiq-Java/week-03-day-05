package com.example.bankmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CustomerDetails {
@Id
    @NotEmpty(message = "id is required")
    private String id ;
    //----------------------------
    @NotNull(message = "age is required")
    private Integer age ;

    //--------------------------------
    @NotNull(message = "balance is required")
    private Integer balance ;

    public String getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getBalance() {
        return balance;
    }

    public Customers getCustomers() {
        return customers;
    }

    @OneToOne(cascade  = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customers customers;

}

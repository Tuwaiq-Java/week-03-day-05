package com.example.bankmanagementsystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Bank {
    @Id
    @NotEmpty(message = "id is required")
    private String id ;
    //----------------------------
    @NotEmpty(message = "name is required")
    private String name ;

    @ManyToOne
    @JsonIgnore
    private Customers customers;

}

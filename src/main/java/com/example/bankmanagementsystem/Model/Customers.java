package com.example.bankmanagementsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customers {
@Id
    @NotEmpty(message = "id is required")
    private String id ;
    //----------------------------
    @NotEmpty(message = "USERNAME is required")
    private String username ;


    @OneToOne(mappedBy = "customers",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;

    @OneToMany(mappedBy = "customers",cascade = CascadeType.ALL)
    private Set<Bank> branches;
}

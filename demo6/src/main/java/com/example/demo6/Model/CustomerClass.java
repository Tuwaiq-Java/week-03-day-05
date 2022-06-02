package com.example.demo6.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@Entity
public class CustomerClass{
    @Id
    @NotNull(message = "Write a Yours ID !")
    private Integer id;
    @NotEmpty(message = "Write a UserName !")
    public String username;



    @OneToMany(mappedBy = "customerClass",cascade = CascadeType.ALL)
    private Set<BankClass> bankClass;

    @OneToOne
    private CustomerDetails customerDetails;

}

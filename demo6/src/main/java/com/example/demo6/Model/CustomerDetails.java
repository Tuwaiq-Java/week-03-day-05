package com.example.demo6.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class CustomerDetails {
    @Id
    @NotNull(message = "Write a Id Number !")
    private Integer id;
    @NotNull(message = "Write a Your Age !")
    private Integer age;
    @NotNull(message = "Write a Your Balance")
    private Integer balance;


    @OneToOne
    private CustomerClass customerClass;

}

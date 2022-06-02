package com.example.demo6.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@Entity
public class BankClass {
    @Id
    @NotNull(message = "Write a Id Number !")
    private Integer id;
    @NotEmpty(message = "Write a Yours Name !")
    private String name;
    @ManyToOne
    private CustomerClass customerClass;
}

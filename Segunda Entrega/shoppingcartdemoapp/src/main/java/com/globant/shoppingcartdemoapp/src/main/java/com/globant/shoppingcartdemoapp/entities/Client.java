package com.globant.shoppingcartdemoapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="CLIENT")
public class Client {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String lastName;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//
    private List<Payment> payment;


    public Client(String name, String lastName, String description) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
    }



}

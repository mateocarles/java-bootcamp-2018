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
<<<<<<< HEAD

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)//
    private List<Payment> payment;


    public Client(String name, String lastName, String description) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
=======

    @OneToMany( cascade = CascadeType.ALL)
    private List<Payment> payment;

    public Client() {
        this.payment = new ArrayList<>();
    }

    public String toString() {
        return "";
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2
    }



}

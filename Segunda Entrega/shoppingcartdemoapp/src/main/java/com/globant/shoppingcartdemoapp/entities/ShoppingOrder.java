package com.globant.shoppingcartdemoapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SHOPPING_ORDER")
public class ShoppingOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;


    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> item;



}

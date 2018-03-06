package com.globant.shoppingcartdemoapp.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="ITEM")
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String name;


}

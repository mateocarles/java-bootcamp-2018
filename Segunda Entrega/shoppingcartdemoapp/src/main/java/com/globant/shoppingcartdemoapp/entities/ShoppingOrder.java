package com.globant.shoppingcartdemoapp.entities;


<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

=======
import lombok.Data;
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2
import java.util.*;


import javax.persistence.*;


@Entity
@Data
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SHOPPING_ORDER")
=======
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2
public class ShoppingOrder {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;


<<<<<<< HEAD
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Item> item;


=======
    @OneToMany( cascade = CascadeType.ALL)
    private List<Item> item;

    public ShoppingOrder(){
        this.item = new LinkedList<>();
    }
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2

}

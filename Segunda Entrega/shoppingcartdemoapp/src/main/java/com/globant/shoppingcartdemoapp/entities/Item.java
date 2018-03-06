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

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name="SHOPPING_ORDER_ID")
    private ShoppingOrder shoppingOrder;
=======
    @OneToOne
    private ShoppingOrder shoppingOrder;



>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2
}

package com.globant.shoppingcartdemoapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private float amount;


    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private ShoppingOrder shoppingOrder;

    public Payment(float amount, ShoppingOrder shoppingOrder) {
        this.amount = amount;
        this.shoppingOrder = shoppingOrder;
    }
}

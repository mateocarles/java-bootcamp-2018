package com.globant.shoppingcartdemoapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import lombok.Data;
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2

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


<<<<<<< HEAD
    @OneToOne( cascade = CascadeType.ALL, orphanRemoval = true)
    private ShoppingOrder shoppingOrder;
=======
    @OneToOne( cascade = CascadeType.ALL)
    private ShoppingOrder shoppingOrder;

    @ManyToOne
    private Client client;

    public Payment(){
        this.shoppingOrder = null;
    }

    @JsonIgnore
    public Client getClient(){
        return this.client;
    }

>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2

    public Payment(float amount, ShoppingOrder shoppingOrder) {
        this.amount = amount;
        this.shoppingOrder = shoppingOrder;
    }
}

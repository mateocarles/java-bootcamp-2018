package com.globant.shoppingcartdemoapp.repository;

import com.globant.shoppingcartdemoapp.entities.Client;
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
=======
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.Order;

<<<<<<< HEAD
public interface OrderRepository extends JpaRepository<ShoppingOrder,Integer> {


=======
public interface OrderRepository extends CrudRepository<ShoppingOrder,Integer> {

    ShoppingOrder getById(int orderId);
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2

}



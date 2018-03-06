package com.globant.shoppingcartdemoapp.repository;

import com.globant.shoppingcartdemoapp.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.Order;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Integer> {


    List<Payment> findAllByShoppingOrderId(int id);

<<<<<<< HEAD
=======
    List<Payment> findAllByClientId(int clientId);
    Payment findById(int paymentId);

>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2
}

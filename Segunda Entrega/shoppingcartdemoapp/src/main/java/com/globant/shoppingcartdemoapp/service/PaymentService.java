package com.globant.shoppingcartdemoapp.service;

import com.globant.shoppingcartdemoapp.dto.PaymentDTO;
import com.globant.shoppingcartdemoapp.entities.Payment;

import java.util.List;

public interface PaymentService {

    void add(PaymentDTO paymentDTO);
    Payment getPayment(int id);
    List<Payment> getAllPayments();
    void updatePayment(PaymentDTO paymentDTO);
    void deletePayment(int id);
}

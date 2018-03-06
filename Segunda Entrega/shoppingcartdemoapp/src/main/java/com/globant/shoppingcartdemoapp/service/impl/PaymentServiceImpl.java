package com.globant.shoppingcartdemoapp.service.impl;

import com.globant.shoppingcartdemoapp.dto.PaymentDTO;
import com.globant.shoppingcartdemoapp.entities.*;
import com.globant.shoppingcartdemoapp.repository.*;
import com.globant.shoppingcartdemoapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {



    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, OrderRepository orderRepository, ClientRepository clientRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }


    public void add(PaymentDTO paymentDTO) {

        int orderId = paymentDTO.getOrderId();
        float amount = paymentDTO.getAmount();

        ShoppingOrder shoppingOrder = orderRepository.findOne(orderId);
        Payment payment = new Payment(amount,shoppingOrder);

        paymentRepository.save(payment);
    }

    public Payment getPayment(int id) {

        return paymentRepository.findOne(id);

    }

    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }


    public List<Payment> getAllPaymentsFromClient(int clientId) {

       return clientRepository.findOne(clientId).getPayment();

    }

    public void updatePayment(PaymentDTO paymentDTO) {

        int paymentId = paymentDTO.getPaymentId();
        float paymentAmount = paymentDTO.getAmount();
        int orderId = paymentDTO.getOrderId();

        Payment payment = paymentRepository.findOne(paymentId);
        ShoppingOrder shoppingOrder = orderRepository.findOne(orderId);

        payment.setAmount(paymentAmount);
        payment.setShoppingOrder(shoppingOrder);

        paymentRepository.save(payment);

    }

    public void deletePayment(int id) {
        paymentRepository.delete(id);
    }
}

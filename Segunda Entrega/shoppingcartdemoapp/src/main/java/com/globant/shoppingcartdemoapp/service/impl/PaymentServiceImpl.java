package com.globant.shoppingcartdemoapp.service.impl;

import com.globant.shoppingcartdemoapp.dto.PaymentDTO;
import com.globant.shoppingcartdemoapp.entities.*;
import com.globant.shoppingcartdemoapp.repository.*;
import com.globant.shoppingcartdemoapp.service.PaymentService;
import org.apache.commons.lang3.Validate;
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
        Validate.notNull(paymentDTO);
        int orderId = paymentDTO.getOrderId();
        float amount = paymentDTO.getAmount();
        int clientId = paymentDTO.getClientId();
        ShoppingOrder shoppingOrder = orderRepository.findOne(orderId);
        Payment payment = Payment.builder()
                .amount(amount)
                .shoppingOrder(shoppingOrder)
                .build();
        clientRepository.findOne(clientId).getPayments().add(payment);
        paymentRepository.save(payment);
    }

    public Payment getPayment(int id) {
        return paymentRepository.getOne(id);
    }

    public List<Payment> getAllPayments() {

        return paymentRepository.findAll();
    }

    public List<Payment> getAllPaymentsFromClient(int clientId) {

       return clientRepository.findOne(clientId).getPayments();

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

package com.globant.shoppingcartdemoapp.controller;
import com.globant.shoppingcartdemoapp.dto.PaymentDTO;
import com.globant.shoppingcartdemoapp.entities.*;
import java.util.*;

import com.globant.shoppingcartdemoapp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping(value="/payment")
public class PaymentController {

    private final PaymentService paymentService;


    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(value="/create",method = RequestMethod.POST)
    public ResponseEntity<PaymentDTO> addPayment(@RequestParam(name = "clientId") int clientId,
                                                 @RequestParam(name = "orderId") int orderId,
                                               @RequestParam(name = "amount") float amount) {

        PaymentDTO paymentDTO = PaymentDTO.builder()
                .orderId(orderId)
                .amount(amount)
                .clientId(clientId)
                .build();

        paymentService.add(paymentDTO);
        return new ResponseEntity<>(paymentDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value="/retrieve/all", method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> paymentList = paymentService.getAllPayments();
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    @RequestMapping(value="/retrieve/clientAll",method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getPaymentsFromClient(@RequestParam(name = "clientId") int clientId) {
        List<Payment> paymentList = paymentService.getAllPaymentsFromClient(clientId);
        return new ResponseEntity<>(paymentList,HttpStatus.OK);
    }

    @RequestMapping(value="/retrieve",method = RequestMethod.GET)
    public ResponseEntity<Payment> getPayment(@RequestParam(name = "paymentId") int paymentId) {
        Payment payment = paymentService.getPayment(paymentId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @RequestMapping(value="/update",method = RequestMethod.PUT)
    public ResponseEntity<PaymentDTO> updatePayment(@RequestParam(name ="paymentId") int paymentId,
                                                    @RequestParam(name = "orderId") int orderId,
                                                    @RequestParam(name = "amount") float amount) {

        PaymentDTO paymentDTO = PaymentDTO.builder()
                .paymentId(paymentId)
                .orderId(orderId)
                .amount(amount)
                .build();
        paymentService.updatePayment(paymentDTO);
        return new ResponseEntity<>(paymentDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value="/delete",method = RequestMethod.DELETE)
    public void deletePayment(@RequestParam(name = "paymentId") int paymentId) {

        paymentService.deletePayment(paymentId);
    }

}

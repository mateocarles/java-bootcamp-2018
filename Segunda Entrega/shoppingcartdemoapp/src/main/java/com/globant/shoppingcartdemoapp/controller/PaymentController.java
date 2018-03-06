package com.globant.shoppingcartdemoapp.controller;
import com.globant.shoppingcartdemoapp.dto.PaymentDTO;
import com.globant.shoppingcartdemoapp.entities.*;
import java.util.*;

import com.globant.shoppingcartdemoapp.service.impl.ClientServiceImpl;
import com.globant.shoppingcartdemoapp.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    private final PaymentServiceImpl paymentServiceImpl;


    @Autowired
    public PaymentController(PaymentServiceImpl paymentService) {
        this.paymentServiceImpl = paymentService;
    }

    @RequestMapping(value="/payment",method = RequestMethod.POST)
    public ResponseEntity<PaymentDTO> addPayment(@RequestParam(name = "orderId") int orderId,
                                               @RequestParam(name = "amount") float amount) {

        PaymentDTO paymentDTO = new PaymentDTO(orderId,amount);
        paymentServiceImpl.add(paymentDTO);
        return new ResponseEntity<>(paymentDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value="/payments", method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> paymentList = paymentServiceImpl.getAllPayments();
        return new ResponseEntity<>(paymentList, HttpStatus.OK);
    }

    @RequestMapping(value="/payments",method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> getPaymentsFromClient(@RequestParam(name = "clientId") int clientId) {
        List<Payment> paymentList = paymentServiceImpl.getAllPaymentsFromClient(clientId);
        return new ResponseEntity<>(paymentList,HttpStatus.OK);
    }

    @RequestMapping(value="/payment",method = RequestMethod.GET)
    public ResponseEntity<Payment> getPayment(@RequestParam(name = "paymentId") int paymentId) {
        Payment payment = paymentServiceImpl.getPayment(paymentId);
        return new ResponseEntity<>(payment, HttpStatus.OK);
    }

    @RequestMapping(value="/payment",method = RequestMethod.POST)
    public ResponseEntity<PaymentDTO> updatePayment(@RequestParam(name ="paymentId") int paymentId,
                                                    @RequestParam(name = "orderId") int orderId,
                                                    @RequestParam(name = "amount") float amount) {

        PaymentDTO paymentDTO = new PaymentDTO(paymentId,orderId,amount);
        paymentServiceImpl.updatePayment(paymentDTO);
        return new ResponseEntity<>(paymentDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value="/payment",method = RequestMethod.DELETE)
    public void deletePayment(@RequestParam(name = "paymentId") int paymentId) {

        paymentServiceImpl.deletePayment(paymentId);
    }

}

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

<<<<<<< HEAD
    @RequestMapping(value="/payment",method = RequestMethod.POST)
    public ResponseEntity<PaymentDTO> addPayment(@RequestParam(name = "orderId") int orderId,
                                               @RequestParam(name = "amount") float amount) {

        PaymentDTO paymentDTO = new PaymentDTO(orderId,amount);
        paymentServiceImpl.add(paymentDTO);
        return new ResponseEntity<>(paymentDTO, HttpStatus.CREATED);
    }
=======
    @RequestMapping(value="/client/{clientId}/payment",method = RequestMethod.POST)
    public void addPayment(@RequestBody Payment payment, @PathVariable int clientId) {
        Client c = clientService.getClient(clientId);
        c.getPayment().add(payment);
        payment.setClient(c);
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2

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

<<<<<<< HEAD
        PaymentDTO paymentDTO = new PaymentDTO(paymentId,orderId,amount);
        paymentServiceImpl.updatePayment(paymentDTO);
        return new ResponseEntity<>(paymentDTO, HttpStatus.CREATED);
=======
        Client c = clientService.getClient(clientId);
        for(int i = 0 ; i < c.getPayment().size() ; i++) {
            if(c.getPayment().get(i).getId() == clientId) {
                c.getPayment().add(i,payment);
            }
        }
        paymentService.updatePayment(payment);
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2
    }

    @RequestMapping(value="/payment",method = RequestMethod.DELETE)
    public void deletePayment(@RequestParam(name = "paymentId") int paymentId) {

<<<<<<< HEAD
        paymentServiceImpl.deletePayment(paymentId);
=======
        Client c = clientService.getClient(clientId);
        for(int i = 0 ; i < c.getPayment().size() ; i++) {
            if(c.getPayment().get(i).getId() == clientId) {
                c.getPayment().remove(i);
            }
        }
        paymentService.deletePayment(paymentId);
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2
    }

}

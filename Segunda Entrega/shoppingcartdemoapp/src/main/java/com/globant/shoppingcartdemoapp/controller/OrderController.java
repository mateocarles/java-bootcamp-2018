package com.globant.shoppingcartdemoapp.controller;


import com.globant.shoppingcartdemoapp.dto.OrderDTO;
import com.globant.shoppingcartdemoapp.entities.Item;
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;
import com.globant.shoppingcartdemoapp.entities.Payment;
import com.globant.shoppingcartdemoapp.service.impl.ItemServiceImpl;
import com.globant.shoppingcartdemoapp.service.impl.OrderServiceImpl;
import com.globant.shoppingcartdemoapp.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD

import java.util.List;
=======
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2

@RestController
public class OrderController {


    private final OrderServiceImpl orderServiceImpl;

<<<<<<< HEAD
    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl) {
=======
    @RequestMapping(value="/client/{idClient}/payment/{idPayment}/orders", method = RequestMethod.POST)
    public void addOrder(@RequestBody ShoppingOrder shoppingOrder, @PathVariable int idPayment) {
        Payment p = paymentService.getPayment(idPayment);
        p.setShoppingOrder(shoppingOrder);
        orderService.addOrder(shoppingOrder);

    }
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2

        this.orderServiceImpl = orderServiceImpl;
    }


<<<<<<< HEAD
    @RequestMapping(value="/order", method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> addOrder(@RequestParam(name = "itemIds") List<Integer> itemIds) {

        final OrderDTO orderDTO = new OrderDTO(itemIds);
        orderServiceImpl.addOrder(orderDTO);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);

    }


    @RequestMapping(value="/order",method = RequestMethod.GET)
    public ResponseEntity<ShoppingOrder> getOrder(@PathVariable int orderId) {

        final ShoppingOrder order = orderServiceImpl.getOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value="/order",method = RequestMethod.PUT)
    public ResponseEntity<OrderDTO> updateOrder(@RequestParam(name = "orderId") int orderId,
                                                @RequestParam(name = "itemIds") List<Integer> itemIds) {

        final OrderDTO orderDTO = new OrderDTO(itemIds);
        orderServiceImpl.updateOrder(orderDTO,orderId);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
=======
       Item i = itemService.getItem(idItem);
       ShoppingOrder o = orderService.getOrder(idOrder);

       o.getItem().add(i);

    }

    @RequestMapping(value="client/{idClient}/payment/{idPayment}/order/{orderId}",method = RequestMethod.GET)
    public ShoppingOrder getOrder(@PathVariable int orderId) {
        return orderService.getOrder(orderId);
    }

    @RequestMapping(value="client/{idClient}/payment/{idPayment}/order",method = RequestMethod.PUT)
    public void updateOrder(@PathVariable ShoppingOrder shoppingOrder) {
        orderService.updateOrder(shoppingOrder);
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2
    }

    @RequestMapping(value="/order",method = RequestMethod.DELETE)
    public void deleteOrder(@RequestParam(name = "orderId") int orderId) {
        orderServiceImpl.deleteOrder(orderId);
    }




}

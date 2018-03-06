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

import java.util.List;

@RestController
public class OrderController {


    private final OrderServiceImpl orderServiceImpl;

    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl) {

        this.orderServiceImpl = orderServiceImpl;
    }


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
    }

    @RequestMapping(value="/order",method = RequestMethod.DELETE)
    public void deleteOrder(@RequestParam(name = "orderId") int orderId) {
        orderServiceImpl.deleteOrder(orderId);
    }




}

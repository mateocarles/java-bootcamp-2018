package com.globant.shoppingcartdemoapp.controller;


import com.globant.shoppingcartdemoapp.dto.OrderDTO;
import com.globant.shoppingcartdemoapp.entities.Item;
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;
import com.globant.shoppingcartdemoapp.entities.Payment;
import com.globant.shoppingcartdemoapp.service.OrderService;
import com.globant.shoppingcartdemoapp.service.impl.ItemServiceImpl;
import com.globant.shoppingcartdemoapp.service.impl.OrderServiceImpl;
import com.globant.shoppingcartdemoapp.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrderController {


    private final OrderService orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderServiceImpl) {

        this.orderService = orderServiceImpl;
    }


    @RequestMapping(value="/order", method = RequestMethod.POST)
    public ResponseEntity<OrderDTO> addOrder(@RequestParam(name = "itemIds") List<Integer> itemIds) {

        final OrderDTO orderDTO = OrderDTO.builder()
                .itemIds(itemIds)
                .build();
        ShoppingOrder order = orderService.addOrder(orderDTO);

        List<Integer> itemIds1 = order.getItems().stream()
                .map(Item::getId)
                .collect(Collectors.toList());

        OrderDTO orderDTO1 = OrderDTO.builder()
                .id(order.getId())
                .itemIds(itemIds1)
                .build();

        return new ResponseEntity<>(orderDTO1, HttpStatus.CREATED);

    }


    @RequestMapping(value="/order",method = RequestMethod.GET)
    public ResponseEntity<ShoppingOrder> getOrder(@RequestParam(name ="orderId") int orderId) {

        final ShoppingOrder order = orderService.getOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @RequestMapping(value="/order",method = RequestMethod.PUT)
    public ResponseEntity<OrderDTO> updateOrder(@RequestParam(name = "orderId") int orderId,
                                                @RequestParam(name = "itemIds") List<Integer> itemIds) {

        final OrderDTO orderDTO = OrderDTO.builder()
                .itemIds(itemIds)
                .build();
        orderService.updateOrder(orderDTO,orderId);
        return new ResponseEntity<>(orderDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value="/order",method = RequestMethod.DELETE)
    public void deleteOrder(@RequestParam(name = "orderId") int orderId) {
        orderService.deleteOrder(orderId);
    }




}

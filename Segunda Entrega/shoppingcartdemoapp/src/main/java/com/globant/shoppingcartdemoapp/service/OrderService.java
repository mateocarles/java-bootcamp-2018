package com.globant.shoppingcartdemoapp.service;

import com.globant.shoppingcartdemoapp.dto.OrderDTO;
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;

<<<<<<< HEAD
public interface OrderService {

    void addOrder(OrderDTO orderDTO);
    ShoppingOrder getOrder(int orderId);
    void updateOrder(OrderDTO orderDTO, int orderId);
    void deleteOrder(int orderId);
=======
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;
import com.globant.shoppingcartdemoapp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    public void addOrder(ShoppingOrder shoppingOrder) {
        orderRepository.save(shoppingOrder);
    }

    public ShoppingOrder getOrder(int orderId) {
        return orderRepository.getById(orderId);
    }

    public void updateOrder(ShoppingOrder shoppingOrder) {
        orderRepository.save(shoppingOrder);
    }

    public void deleteOrder(int orderId) {
        orderRepository.deleteById(orderId);
    }
>>>>>>> a79fd91506e4ab4e94c9ee68fad557592b1df6a2
}

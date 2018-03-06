package com.globant.shoppingcartdemoapp.service;

import com.globant.shoppingcartdemoapp.dto.OrderDTO;
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;

public interface OrderService {

    void addOrder(OrderDTO orderDTO);
    ShoppingOrder getOrder(int orderId);
    void updateOrder(OrderDTO orderDTO, int orderId);
    void deleteOrder(int orderId);
}

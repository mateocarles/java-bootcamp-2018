package com.globant.shoppingcartdemoapp.service.impl;


import com.globant.shoppingcartdemoapp.dto.OrderDTO;
import com.globant.shoppingcartdemoapp.entities.Item;
import com.globant.shoppingcartdemoapp.entities.ShoppingOrder;
import com.globant.shoppingcartdemoapp.repository.OrderRepository;
import com.globant.shoppingcartdemoapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{


    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(OrderDTO orderDTO) {

        List<Integer> itemIds = orderDTO.getItemIds();
        ShoppingOrder shoppingOrder = new ShoppingOrder();

        //Set the items ids to the item List of ShoppingOrder entity
        for(int i = 0 ; i < itemIds.size() ; i++) {
            Item it = new Item();
            it.setId(itemIds.get(i));
            shoppingOrder.getItem().add(i,it);
        }

        orderRepository.save(shoppingOrder);
    }

    public ShoppingOrder getOrder(int orderId) {
        return orderRepository.findOne(orderId);
    }

    public void updateOrder(OrderDTO orderDTO, int orderId) {

        List<Integer> itemIds = orderDTO.getItemIds();
        ShoppingOrder shoppingOrder = orderRepository.findOne(orderId);

        //Set the items ids to the item List of ShoppingOrder entity
        for(int i = 0 ; i < itemIds.size() ; i++) {
            Item it = new Item();
            it.setId(itemIds.get(i));
            shoppingOrder.getItem().add(i,it);
        }

        orderRepository.save(shoppingOrder);
    }

    public void deleteOrder(int orderId) {

        orderRepository.delete(orderId);
    }
}

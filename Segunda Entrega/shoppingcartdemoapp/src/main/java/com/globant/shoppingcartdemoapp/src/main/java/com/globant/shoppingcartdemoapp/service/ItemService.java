package com.globant.shoppingcartdemoapp.service;

import com.globant.shoppingcartdemoapp.entities.*;

import java.util.List;

public interface ItemService {

    Item addItem(Item item);
    Item getItem(int id);
    void updateItem(Item item);
    void deleteItem(int id);
}

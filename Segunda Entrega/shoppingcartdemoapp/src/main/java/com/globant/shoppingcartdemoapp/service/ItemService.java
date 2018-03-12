package com.globant.shoppingcartdemoapp.service;

import com.globant.shoppingcartdemoapp.dto.ItemDTO;
import com.globant.shoppingcartdemoapp.entities.*;

import java.util.List;

public interface ItemService {

    Item addItem(ItemDTO itemDTO);
    Item getItem(int id);
    void updateItem(ItemDTO itemDTO);
    void deleteItem(int id);
}

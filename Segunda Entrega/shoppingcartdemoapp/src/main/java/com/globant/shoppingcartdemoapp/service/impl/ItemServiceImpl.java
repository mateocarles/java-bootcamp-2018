package com.globant.shoppingcartdemoapp.service.impl;


import com.globant.shoppingcartdemoapp.dto.ItemDTO;
import com.globant.shoppingcartdemoapp.entities.Item;
import com.globant.shoppingcartdemoapp.repository.ItemRepository;
import com.globant.shoppingcartdemoapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {


    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    public Item addItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        return itemRepository.save(item);
    }
    public Item getItem(int itemId) {
       return itemRepository.getOne(itemId);
    }

    public void updateItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        itemRepository.save(item);
    }

    public void deleteItem(int itemId) {
        itemRepository.delete(itemId);
    }
}

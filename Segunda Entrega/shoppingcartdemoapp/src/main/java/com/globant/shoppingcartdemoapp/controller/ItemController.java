package com.globant.shoppingcartdemoapp.controller;

import com.globant.shoppingcartdemoapp.entities.*;
import com.globant.shoppingcartdemoapp.service.ItemService;
import com.globant.shoppingcartdemoapp.service.impl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {


    private ItemServiceImpl itemService;

    @Autowired
    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value="/item", method = RequestMethod.POST)
    public ResponseEntity<Item> addItem(@RequestBody Item item) {

        Item it = itemService.addItem(item);
        return new ResponseEntity<>(it,HttpStatus.CREATED);

    }

    @RequestMapping(value="/item/{itemId}", method = RequestMethod.GET)
    public ResponseEntity<Item> getItem(@PathVariable int itemId) {

       Item it = itemService.getItem(itemId);
       return new ResponseEntity<>(it,HttpStatus.FOUND);
    }

    @RequestMapping(value="/item",method = RequestMethod.PUT)
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
        return new ResponseEntity<>(item, HttpStatus.FOUND);
    }

    @RequestMapping(value="/item/{itemId}",method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable int itemId) {
        itemService.deleteItem(itemId);
    }


}

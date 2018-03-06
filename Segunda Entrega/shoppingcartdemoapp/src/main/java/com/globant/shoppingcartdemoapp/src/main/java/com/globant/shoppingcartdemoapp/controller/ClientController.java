package com.globant.shoppingcartdemoapp.controller;
import com.globant.shoppingcartdemoapp.entities.Payment;
import com.globant.shoppingcartdemoapp.service.impl.ClientServiceImpl;
import com.globant.shoppingcartdemoapp.entities.Client;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {


    private ClientServiceImpl clientServiceImpl;

    @Autowired
    private ClientController(ClientServiceImpl clientServiceImpl){
        this.clientServiceImpl = clientServiceImpl;
    }

    @RequestMapping(value="/client",method= RequestMethod.POST)
    public ResponseEntity<Client> addClient(@RequestParam(name = "name") String name,
                                          @RequestParam(name = "lastName") String lastName,
                                          @RequestParam(name = "description") String description) {

        final Client client = new Client(name, lastName, description);
        clientServiceImpl.addClient(client);
        return new ResponseEntity<>(client, HttpStatus.CREATED);

    }

    @RequestMapping(value="/client/{id}",method= RequestMethod.GET)
    public ResponseEntity<Client> getClient(@PathVariable int id) {

        Client client =  clientServiceImpl.getClient(id);
        return new ResponseEntity<>(client, HttpStatus.FOUND);

    }

    @RequestMapping(value="/clients",method= RequestMethod.GET)
    public ResponseEntity<List<Client>>  getAllClients() {

        List<Client> li = clientServiceImpl.getAllClients();
        return new ResponseEntity<>(li,HttpStatus.FOUND);

    }

    @RequestMapping(value="/client", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        clientServiceImpl.updateClient(client);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }

    @RequestMapping(value="/client/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteClient(@PathVariable int id) {
        clientServiceImpl.deleteClient(id);
        return new ResponseEntity<>(id,HttpStatus.FOUND);
    }






}

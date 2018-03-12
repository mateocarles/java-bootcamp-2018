package com.globant.shoppingcartdemoapp.controller;
import com.globant.shoppingcartdemoapp.dto.ClientDTO;
import com.globant.shoppingcartdemoapp.service.ClientService;
import com.globant.shoppingcartdemoapp.service.impl.ClientServiceImpl;
import com.globant.shoppingcartdemoapp.entities.Client;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {


    private ClientService clientService;

    @Autowired
    private ClientController(ClientServiceImpl clientServiceImpl){
        this.clientService = clientServiceImpl;
    }

    @RequestMapping(value="/client",method= RequestMethod.POST)
    public ResponseEntity<ClientDTO> addClient(@RequestParam(name = "name") String name,
                                          @RequestParam(name = "lastName") String lastName,
                                          @RequestParam(name = "description") String description) {

        ClientDTO clientDTO = ClientDTO.builder()
                .name(name)
                .lastName(lastName)
                .description(description)
                .build();

        clientService.addClient(clientDTO);
        return new ResponseEntity<>(clientDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value="/client/{id}",method= RequestMethod.GET)
    public ResponseEntity<Client> getClient(@PathVariable int id) {

        Client client =  clientService.getClient(id);
        return new ResponseEntity<>(client, HttpStatus.OK);

    }

    @RequestMapping(value="/clients",method= RequestMethod.GET)
    public ResponseEntity<List<Client>>  getAllClients() {

        List<Client> li = clientService.getAllClients();
        return new ResponseEntity<>(li,HttpStatus.FOUND);

    }

    @RequestMapping(value="/client", method = RequestMethod.PUT)
    public ResponseEntity<Client> updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
        return new ResponseEntity<>(client,HttpStatus.OK);
    }

    @RequestMapping(value="/client/{id}",method=RequestMethod.DELETE)
    public ResponseEntity<Integer> deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
        return new ResponseEntity<>(id,HttpStatus.FOUND);
    }






}

package com.globant.shoppingcartdemoapp.service.impl;
import com.globant.shoppingcartdemoapp.dto.ClientDTO;
import com.globant.shoppingcartdemoapp.entities.*;
import java.util.*;

import com.globant.shoppingcartdemoapp.repository.ClientRepository;
import com.globant.shoppingcartdemoapp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    public void addClient(ClientDTO clientDTO) {

        String name = clientDTO.getName();
        String lastName = clientDTO.getLastName();
        String description = clientDTO.getDescription();

        Client client = Client.builder()
                .name(name)
                .lastName(lastName)
                .description(description)
                .build();

        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        clientRepository.findAll()
                .forEach(clients::add);

        return clients;
    }

    public Client getClient(int id) {

        return clientRepository.findOne(id);
    }


    public void updateClient(Client client) {

        clientRepository.save(client);
    }

    public void deleteClient(int id) {

        clientRepository.delete(id);
    }
}

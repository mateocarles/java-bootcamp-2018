package com.globant.shoppingcartdemoapp.service.impl;
import com.globant.shoppingcartdemoapp.dto.ClientDTO;
import com.globant.shoppingcartdemoapp.entities.*;
import java.util.*;

import com.globant.shoppingcartdemoapp.repository.ClientRepository;
import com.globant.shoppingcartdemoapp.service.ClientService;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client addClient(ClientDTO clientDTO) {
        Validate.notNull(clientDTO);
        Validate.notEmpty(clientDTO.getName());
        Validate.notEmpty(clientDTO.getDescription());
        Validate.notEmpty(clientDTO.getLastName());
        String name = clientDTO.getName();
        String lastName = clientDTO.getLastName();
        String description = clientDTO.getDescription();
        Client client = Client.builder()
                .name(name)
                .lastName(lastName)
                .description(description)
                .build();
      return  clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClient(int id) {
        return clientRepository.getOne(id);
    }

    public void updateClient(Client client) {
        clientRepository.save(client);
    }

    public void deleteClient(int id) {
        clientRepository.delete(id);
    }
}

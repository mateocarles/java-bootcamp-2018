package com.globant.shoppingcartdemoapp.service;

import com.globant.shoppingcartdemoapp.entities.Client;

import java.util.List;

public interface ClientService {

    void addClient(Client client);
    List<Client> getAllClients();
    Client getClient(int id);
    void updateClient(Client client);
    void deleteClient(int id);
}

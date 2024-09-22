package org.baticuisine.dao;

import org.baticuisine.entities.Client;

import java.util.List;

public interface ClientDAO {
    void addClient(Client client) ;
    List<Client> getAllClients();
}

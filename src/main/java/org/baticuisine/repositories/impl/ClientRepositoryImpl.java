package org.baticuisine.repositories.impl;

import org.baticuisine.dao.ClientDAO;
import org.baticuisine.dao.impl.ClientDAOImpl;
import org.baticuisine.entities.Client;
import org.baticuisine.repositories.ClientRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientRepositoryImpl implements ClientRepository {
    private ClientDAO clientDAO;
    private Map<String, Client> clientMap = new HashMap<>();

    {
        clientDAO = new ClientDAOImpl();
        loadAllClients();
    }
    @Override
    public void save(Client client) {
        if(client != null) {
           clientDAO.addClient(client);
           clientMap.put(client.getNom(), client);
        }
    }

    private void loadAllClients() {
        List<Client> clients = clientDAO.getAllClients();
        for (Client client : clients) {
            clientMap.put(client.getNom(), client);
        }
    }

    @Override
    public Client getClientByName(String name) {
        return clientMap.get(name);
    }
}

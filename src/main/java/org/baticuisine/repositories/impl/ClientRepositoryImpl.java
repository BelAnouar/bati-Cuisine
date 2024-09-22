package org.baticuisine.repositories.impl;

import org.baticuisine.dao.ClientDAO;
import org.baticuisine.dao.impl.ClientDAOImpl;
import org.baticuisine.entities.Client;
import org.baticuisine.repositories.ClientRepository;

public class ClientRepositoryImpl implements ClientRepository {
    private ClientDAO clientDAO;
    {
        clientDAO = new ClientDAOImpl();
    }
    @Override
    public void save(Client client) {

        if(client != null) {
           clientDAO.addClient(client);
        }
    }
}

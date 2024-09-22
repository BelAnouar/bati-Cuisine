package org.baticuisine.services.impl;

import org.baticuisine.entities.Client;
import org.baticuisine.repositories.ClientRepository;
import org.baticuisine.repositories.impl.ClientRepositoryImpl;
import org.baticuisine.services.ClientService;

public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;
    {
        clientRepository = new ClientRepositoryImpl();
    }
    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }
}

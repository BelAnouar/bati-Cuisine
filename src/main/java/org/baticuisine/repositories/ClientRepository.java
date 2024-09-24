package org.baticuisine.repositories;

import org.baticuisine.entities.Client;

public interface ClientRepository {
    void save(Client client);
    Client getClientByName(String name);

}

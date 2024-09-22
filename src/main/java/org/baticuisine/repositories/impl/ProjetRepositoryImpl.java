package org.baticuisine.repositories.impl;


import org.baticuisine.dao.ProjetDAO;

import org.baticuisine.dao.impl.ProjetDAOImpl;
import org.baticuisine.entities.Projet;
import org.baticuisine.repositories.ProjetRepository;

public class ProjetRepositoryImpl implements ProjetRepository {
    private ProjetDAO projetDAO;

    {
        projetDAO = new ProjetDAOImpl();
    }

    @Override
    public void save(Projet projet) {
        projetDAO.addClient(projet);
    }
}

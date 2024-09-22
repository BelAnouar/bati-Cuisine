package org.baticuisine.services.impl;


import org.baticuisine.entities.Projet;

import org.baticuisine.repositories.ProjetRepository;

import org.baticuisine.repositories.impl.ProjetRepositoryImpl;
import org.baticuisine.services.ProjetService;

public class ProjetServiceImpl implements ProjetService {

    private ProjetRepository projetRepository;
    {
        projetRepository = new ProjetRepositoryImpl();
    }

    @Override
    public void createProjet(Projet projet) {
       projetRepository.save(projet);
    }
}

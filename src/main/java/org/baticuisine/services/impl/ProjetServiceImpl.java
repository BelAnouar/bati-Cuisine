package org.baticuisine.services.impl;


import org.baticuisine.entities.Projet;

import org.baticuisine.enums.Etat;
import org.baticuisine.repositories.ProjetRepository;

import org.baticuisine.repositories.impl.ProjetRepositoryImpl;
import org.baticuisine.services.ProjetService;

import java.util.List;

public class ProjetServiceImpl implements ProjetService {

    private ProjetRepository projetRepository;
    {
        projetRepository = new ProjetRepositoryImpl();
    }

    @Override
    public void createProjet(Projet projet) {
       projetRepository.save(projet);
    }

    @Override
    public List<Projet> getProjets() {
     return    projetRepository.findAll();
    }

    @Override
    public void updateProject(Projet projet) {
        projetRepository.updateProject(projet.getId(), projet.getCoutTotal(), projet.getMargeBeneficiaire());
    }

    @Override
    public void updateEtatProject(Projet projet, Etat etat) {
        projetRepository.updateEtatProject(projet.getId(), etat );
    }
}

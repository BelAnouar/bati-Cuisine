package org.baticuisine.services;


import org.baticuisine.entities.Projet;

import java.util.List;

public interface ProjetService {
    void createProjet(Projet projet);
    List<Projet> getProjets();
}

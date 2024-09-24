package org.baticuisine.services;


import org.baticuisine.entities.Projet;
import org.baticuisine.enums.Etat;

import java.util.List;

public interface ProjetService {
    void createProjet(Projet projet);
    List<Projet> getProjets();
    void updateProject(Projet projet);
    void updateEtatProject(Projet projet, Etat etat);
}

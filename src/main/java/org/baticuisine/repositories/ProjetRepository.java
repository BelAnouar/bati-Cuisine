package org.baticuisine.repositories;


import org.baticuisine.entities.Projet;
import org.baticuisine.enums.Etat;

import java.util.List;

public interface ProjetRepository {

    void save(Projet projet);
    List<Projet> findAll();

   void updateProject(int projectId, double coutTotal, double margeBeneficiaire);
   void updateEtatProject(int projectId, Etat etat);
}

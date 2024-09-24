package org.baticuisine.dao;


import org.baticuisine.entities.Projet;
import org.baticuisine.enums.Etat;

import java.util.List;

public interface ProjetDAO {

    void addClient(Projet projet) ;
    List<Projet> getAllProjects();
    void updateProject(int projectId, double coutTotal, double margeBeneficiaire);
    void updateEtatProject(int projectId, Etat etat);
}

package org.baticuisine.repositories;


import org.baticuisine.entities.Projet;

import java.util.List;

public interface ProjetRepository {

    void save(Projet projet);
    List<Projet> findAll();
    Projet findByName(String name);
}

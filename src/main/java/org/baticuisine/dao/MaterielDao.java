package org.baticuisine.dao;

import org.baticuisine.entities.Materiel;

import java.util.List;

public interface MaterielDao {
    void save(Materiel materiel);
    List<Materiel> getAllMateriel();
    List<Materiel> getMaterielByIdProjet(int id);
}

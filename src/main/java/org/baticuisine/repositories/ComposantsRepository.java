package org.baticuisine.repositories;

import org.baticuisine.entities.Composants;
import org.baticuisine.entities.MainOeuvre;
import org.baticuisine.entities.Materiel;

import java.util.List;

public interface ComposantsRepository {
    void saveComposants(Composants composants);
    Materiel  getMaterielById(int id);
    MainOeuvre  getMainOeuvreById(int id);
    List<Materiel>  getMaterielByIdProjet(int id);
    List<MainOeuvre>  getMainOeuvreByIdProjet(int id);
}

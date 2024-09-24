package org.baticuisine.services;

import org.baticuisine.entities.Composants;
import org.baticuisine.entities.MainOeuvre;
import org.baticuisine.entities.Materiel;

import java.util.List;

public interface ComposantsService {

    void addComposant(Composants composant);
    List<Materiel> getMaterielByIdProjet(int id);
    List<MainOeuvre> getMainOeuvreByIdProjet(int id);
  Materiel getMaterielByIdMaterial(int id);
  MainOeuvre getMainOeuvreByIdMainOeuvre(int id);

}

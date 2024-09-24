package org.baticuisine.services.impl;

import org.baticuisine.entities.Composants;
import org.baticuisine.entities.MainOeuvre;
import org.baticuisine.entities.Materiel;
import org.baticuisine.repositories.ComposantsRepository;
import org.baticuisine.repositories.impl.ComposantsRepositoryImpl;
import org.baticuisine.services.ComposantsService;

import java.util.List;

public class ComposantsServiceInmpl implements ComposantsService {
    private ComposantsRepository composantsRepository;
    {
        composantsRepository = new ComposantsRepositoryImpl();
    }
    @Override
    public void addComposant(Composants composant) {
     composantsRepository.saveComposants(composant);
    }

    @Override
    public List<Materiel> getMaterielByIdProjet(int id) {
        return composantsRepository.getMaterielByIdProjet(id);
    }

    @Override
    public List<MainOeuvre> getMainOeuvreByIdProjet(int id) {
     return composantsRepository.getMainOeuvreByIdProjet(id);
    }

    @Override
    public Materiel getMaterielByIdMaterial(int id) {
        return composantsRepository.getMaterielById(id);
    }

    @Override
    public MainOeuvre getMainOeuvreByIdMainOeuvre(int id) {
        return composantsRepository.getMainOeuvreById(id);
    }


}

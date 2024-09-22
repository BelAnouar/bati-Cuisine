package org.baticuisine.services.impl;

import org.baticuisine.entities.Composants;
import org.baticuisine.repositories.ComposantsRepository;
import org.baticuisine.repositories.impl.ComposantsRepositoryImpl;
import org.baticuisine.services.ComposantsService;

public class ComposantsServiceInmpl implements ComposantsService {
    private ComposantsRepository composantsRepository;
    {
        composantsRepository = new ComposantsRepositoryImpl();
    }
    @Override
    public void addComposant(Composants composant) {
composantsRepository.saveComposants(composant);
    }
}

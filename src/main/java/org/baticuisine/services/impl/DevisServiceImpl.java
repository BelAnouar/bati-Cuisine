package org.baticuisine.services.impl;


import org.baticuisine.entities.Devis;
import org.baticuisine.repositories.DevisRepository;
import org.baticuisine.repositories.impl.DevisRepositoryImpl;
import org.baticuisine.services.DevisService;

public class DevisServiceImpl implements DevisService {
    private DevisRepository devisRepository;
    {
        devisRepository = new DevisRepositoryImpl();
    }
    @Override
    public void createDevis(Devis devis) {
        devisRepository.save(devis);
    }
}

package org.baticuisine.repositories.impl;

import org.baticuisine.dao.DevisDAO;
import org.baticuisine.dao.impl.DevisDAOImpl;
import org.baticuisine.entities.Devis;
import org.baticuisine.repositories.DevisRepository;

public class DevisRepositoryImpl implements DevisRepository {
    private DevisDAO devisDAO;
    {
        devisDAO = new DevisDAOImpl();
    }

    @Override
    public void save(Devis devis) {
        devisDAO.insertDevis(devis);
    }
}

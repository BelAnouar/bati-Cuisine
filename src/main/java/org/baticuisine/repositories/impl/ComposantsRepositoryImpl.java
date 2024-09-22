package org.baticuisine.repositories.impl;

import org.baticuisine.dao.ClientDAO;
import org.baticuisine.dao.MainOeuvreDao;
import org.baticuisine.dao.MaterielDao;

import org.baticuisine.dao.impl.MainOeuvreDaoImpl;
import org.baticuisine.dao.impl.MaterialDaoImpl;
import org.baticuisine.entities.Composants;
import org.baticuisine.entities.MainOeuvre;
import org.baticuisine.entities.Materiel;
import org.baticuisine.enums.TypeComposant;
import org.baticuisine.repositories.ComposantsRepository;

public class ComposantsRepositoryImpl implements ComposantsRepository {

    private MaterielDao materielDao;
    private MainOeuvreDao mainOeuvreDao;
    {
        materielDao = new MaterialDaoImpl();
        mainOeuvreDao = new MainOeuvreDaoImpl();
    }
    @Override
    public void saveComposants(Composants composants) {
        if (composants.getTypeComposant() == TypeComposant.MATERIEL) {
            Materiel materiel = (Materiel) composants;
            materielDao.save(materiel);
        } else if (composants.getTypeComposant() == TypeComposant.MAIN_DOEUVRE) {
            MainOeuvre mainOeuvre = (MainOeuvre) composants;
            mainOeuvreDao.insertOeuvre(mainOeuvre);
        } else {
            System.out.println("Unknown TypeComposant");
        }
    }
}

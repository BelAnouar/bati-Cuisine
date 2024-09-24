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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComposantsRepositoryImpl implements ComposantsRepository {

    private MaterielDao materielDao;
    private MainOeuvreDao mainOeuvreDao;
    private Map<Integer, Materiel> materielMap = new HashMap<>();
    private Map<Integer, MainOeuvre> mainOeuvreMap = new HashMap<>();
    {
        materielDao = new MaterialDaoImpl();
        mainOeuvreDao = new MainOeuvreDaoImpl();

    }
    @Override
    public void saveComposants(Composants composants) {
        if (composants.getTypeComposant() == TypeComposant.MATERIEL) {
            Materiel materiel = (Materiel) composants;
            materielDao.save(materiel);
            materielMap.put(materiel.getProjet().getId(), materiel);
        } else if (composants.getTypeComposant() == TypeComposant.MAIN_DOEUVRE) {
            MainOeuvre mainOeuvre = (MainOeuvre) composants;
            mainOeuvreDao.insertOeuvre(mainOeuvre);
            mainOeuvreMap.put(mainOeuvre.getProjet().getId(), mainOeuvre);
        } else {
            System.out.println("Unknown TypeComposant");
        }
    }

    private void loadAllComposants() {

        List<Materiel> allMateriels = materielDao.getAllMateriel();
        List<MainOeuvre> allMainOeuvres = mainOeuvreDao.getAllMainOeuvre();


        for (Materiel materiel : allMateriels) {
            materielMap.put(materiel.getProjet().getId(), materiel);
        }

        for (MainOeuvre mainOeuvre : allMainOeuvres) {
            mainOeuvreMap.put(mainOeuvre.getProjet().getId(), mainOeuvre);
        }
    }



    @Override
    public List<Materiel>  getMaterielByIdProjet(int id) {
        return materielDao.getMaterielByIdProjet(id);
    }
    @Override
    public List<MainOeuvre> getMainOeuvreByIdProjet(int id) {
        return mainOeuvreDao.getMainOeuvreByIdProjet(id);
    }
}
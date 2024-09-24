package org.baticuisine.dao;

import org.baticuisine.entities.MainOeuvre;

import java.util.List;

public interface MainOeuvreDao {
    void insertOeuvre(MainOeuvre mainOeuvre);
    List<MainOeuvre> getAllMainOeuvre();
    List<MainOeuvre> getMainOeuvreByIdProjet(int id);
}

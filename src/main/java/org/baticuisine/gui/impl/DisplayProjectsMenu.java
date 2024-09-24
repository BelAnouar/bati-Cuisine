package org.baticuisine.gui.impl;

import org.baticuisine.entities.MainOeuvre;
import org.baticuisine.entities.Projet;
import org.baticuisine.gui.Menu;
import org.baticuisine.services.ComposantsService;
import org.baticuisine.services.ProjetService;
import org.baticuisine.services.impl.ComposantsServiceInmpl;
import org.baticuisine.services.impl.ProjetServiceImpl;

import static org.baticuisine.utils.loggerUtil.info;

public class DisplayProjectsMenu implements Menu {
    private ProjetService projetService;
    private ComposantsService composantsService;
    {
        projetService = new ProjetServiceImpl();
        composantsService=new ComposantsServiceInmpl();

    }
    @Override
    public void start() {
        printMenuHeader();
        projetService.getProjets().stream().forEach(projet -> {
            composantsService.getMainOeuvreByIdProjet(projet.getId()).stream().forEach(s->{
                s.setProjet(projet);
                info(s.toString());
            });

            composantsService.getMaterielByIdProjet(projet.getId()).stream().forEach(s->{
                s.setProjet(projet);
                info(s.toString());
            });
        });
    }

    @Override
    public void printMenuHeader() {
        info("=== Display Existing Projects ===");
    }
}
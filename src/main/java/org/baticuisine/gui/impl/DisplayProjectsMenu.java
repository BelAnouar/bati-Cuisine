package org.baticuisine.gui.impl;

import org.baticuisine.gui.Menu;
import org.baticuisine.services.ProjetService;
import org.baticuisine.services.impl.ProjetServiceImpl;

import static org.baticuisine.utils.loggerUtil.info;

public class DisplayProjectsMenu implements Menu {
    private ProjetService projetService;
    {
        projetService = new ProjetServiceImpl();
    }
    @Override
    public void start() {
        printMenuHeader();
         projetService.getProjets().stream().forEach(System.out::println);
    }

    @Override
    public void printMenuHeader() {
        info("=== Display Existing Projects ===");
    }
}
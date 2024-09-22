package org.baticuisine.gui.impl;

import org.baticuisine.entities.Client;
import org.baticuisine.entities.Projet;

import org.baticuisine.gui.Menu;

import org.baticuisine.services.ProjetService;

import org.baticuisine.services.impl.ProjetServiceImpl;
import org.baticuisine.utils.InputValidator;

import static org.baticuisine.utils.loggerUtil.info;

public class AddProjectDetailsMenu implements Menu {
    private Client client;

    private ProjetService projetService;



    public AddProjectDetailsMenu(Client client) {
        this.client = client;
        projetService = new ProjetServiceImpl();
    }

    @Override
    public void start() {
        printMenuHeader();
        String nomProjet = InputValidator.getValidString("Enter projet name:");
        double surface = InputValidator.getValidInteger("Enter surface:");
        Projet project = new Projet(nomProjet, client,surface);
        projetService.createProjet(project);
        info("Project for client " + client.getNom() + " has been created successfully.");
        new DevisMenu(project).start();
    }

    @Override
    public void printMenuHeader() {
        info("=== Add Project Details ===");
    }


}

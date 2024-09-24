package org.baticuisine.gui.impl;

import org.baticuisine.entities.Devis;
import org.baticuisine.entities.Projet;
import org.baticuisine.enums.Etat;
import org.baticuisine.gui.Menu;
import org.baticuisine.services.DevisService;
import org.baticuisine.services.ProjetService;
import org.baticuisine.services.impl.DevisServiceImpl;
import org.baticuisine.services.impl.ProjetServiceImpl;
import org.baticuisine.utils.InputValidator;

import java.time.LocalDate;

import static org.baticuisine.utils.loggerUtil.info;

public class DevisMenu  implements Menu {

    private Projet projet;
    private DevisService devisService;
    private ProjetService projetService;
    private double montantEstime;
    public  DevisMenu(Projet projet,double montantEstime) {
        this.projet = projet;
        this.montantEstime = montantEstime;
       devisService=new DevisServiceImpl();
       projetService=new ProjetServiceImpl();
    }
    @Override
    public void start() {
        printMenuHeader();

        info("--- Enregistrement du Devis ---");


        LocalDate dateEmission = InputValidator.getValidDate("Enter the emission date (format: yyyy-MM-dd): ");
        LocalDate dateValidite = InputValidator.getValidDate("Enter the validity date (format: yyyy-MM-dd): ");
        boolean accepte = InputValidator.getYesNoInput("Is the quote accepted? (yes/no): ");


        boolean saveQuote = InputValidator.getYesNoInput("Souhaitez-vous enregistrer le devis ? (y/n) : ");

        if (saveQuote) {
            Devis devis = new Devis(montantEstime, dateEmission, dateValidite, accepte,projet);
           projetService.updateProject(projet);
           projetService.updateEtatProject(projet , Etat.Terminé);
            devisService.createDevis(devis);
            info("Devis enregistré avec succès !");
        }

        projetService.updateEtatProject(projet , Etat.Annulé);

        info("--- Fin du projet ---");

    }

    @Override
    public void printMenuHeader() {
        info("=== Devis Projects ===");
    }
}

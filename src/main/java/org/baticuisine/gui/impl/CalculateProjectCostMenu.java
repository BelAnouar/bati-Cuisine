package org.baticuisine.gui.impl;

import org.baticuisine.entities.MainOeuvre;
import org.baticuisine.entities.Materiel;
import org.baticuisine.entities.Projet;
import org.baticuisine.gui.Menu;
import org.baticuisine.services.ComposantsService;
import org.baticuisine.services.impl.ComposantsServiceInmpl;
import org.baticuisine.utils.InputValidator;

import java.time.LocalDate;
import java.util.List;

import static org.baticuisine.utils.loggerUtil.info;


public class CalculateProjectCostMenu implements Menu {
    private Projet projet;
    private ComposantsService composantsService;
    public CalculateProjectCostMenu(Projet projet) {
        this.projet = projet;
        composantsService =new  ComposantsServiceInmpl();
    }
    @Override
    public void start() {
        printMenuHeader();

        if(projet != null) {
            calculateProjectCosts(projet.getId());
        }else {
            int id= InputValidator.getValidInteger("Enter id projet: ");
            calculateProjectCosts(id);
        }
    }

    @Override
    public void printMenuHeader() {
        info("=== CalculateProjectCostMenu ===");
    }

    public void calculateProjectCosts(int projectId) {
        List<Materiel> materiels = composantsService.getMaterielByIdProjet(projectId);
        List<MainOeuvre> mainDoeuvres = composantsService.getMainOeuvreByIdProjet(projectId);
        double totalMaterialCost = 0;
        double totalLaborCost = 0;

        for (Materiel materiel : materiels) {
            totalMaterialCost += materiel.calculateTotalCost();
        }

        for (MainOeuvre mainOeuvre : mainDoeuvres) {
            totalLaborCost += mainOeuvre.calculateTotalCost();
        }


        boolean applyTVA = InputValidator.getYesNoInput("Souhaitez-vous appliquer une TVA au projet ? (y/n) : ");
        double tvaRate = 0;
        if (applyTVA) {

            tvaRate = InputValidator.getValidDouble("Entrez le pourcentage de TVA (%) : ");
        }

        double materialCostWithTVA = applyTVA ? totalMaterialCost * (1 + tvaRate / 100) : totalMaterialCost;
        double laborCostWithTVA = applyTVA ? totalLaborCost * (1 + tvaRate / 100) : totalLaborCost;


        boolean applyMargin = InputValidator.getYesNoInput("Souhaitez-vous appliquer une marge bénéficiaire au projet ? (y/n) : ");
        double marginRate = 0;
        if (applyMargin) {

            marginRate = InputValidator.getValidDouble("Entrez le pourcentage de marge bénéficiaire (%) : ");
        }

        double totalCostBeforeMargin = materialCostWithTVA + laborCostWithTVA;
        double margin = applyMargin ? totalCostBeforeMargin * (marginRate / 100) : 0;
        double finalProjectCost = totalCostBeforeMargin + margin;

        info("--- Résultat du Calcul ---");
        info("Nom du projet : " + projet.getNomProjet());
        info("Client : " + projet.getClient().getNom());
        info("Adresse du chantier : " + projet.getClient().getAdresse());
        info("--- Détail des Coûts ---");
        info("Coût total des matériaux avant TVA : " + totalMaterialCost);
        if (applyTVA) {
            info("Coût total des matériaux avec TVA : " + materialCostWithTVA);
        }
        info("Coût total de la main-d'œuvre avant TVA : " + totalLaborCost);
        if (applyTVA) {
            info("Coût total de la main-d'œuvre avec TVA : " + laborCostWithTVA);
        }
        info("Coût total avant marge : " + totalCostBeforeMargin);
        if (applyMargin) {
            info("Marge bénéficiaire : " + margin);
        }
        info("Coût total final du projet : " + finalProjectCost);
        projet.setMargeBeneficiaire(margin);
        projet.setCoutTotal(totalCostBeforeMargin);
        new DevisMenu(projet, finalProjectCost).start();
    }
}


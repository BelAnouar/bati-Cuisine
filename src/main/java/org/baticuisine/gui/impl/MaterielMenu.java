package org.baticuisine.gui.impl;

import org.baticuisine.entities.Composants;
import org.baticuisine.entities.MainOeuvre;
import org.baticuisine.entities.Materiel;
import org.baticuisine.entities.Projet;
import org.baticuisine.enums.TypeComposant;
import org.baticuisine.gui.Menu;
import org.baticuisine.services.ComposantsService;
import org.baticuisine.services.impl.ComposantsServiceInmpl;
import org.baticuisine.utils.InputValidator;

public class MaterielMenu implements Menu {
    private Projet projet;
    private ComposantsService composantsService;
    public MaterielMenu(Projet projet) {
        this.projet = projet;
        composantsService=new ComposantsServiceInmpl();
    }
    @Override
    public void start() {
        String name = InputValidator.getValidString("Enter the material name: ");
        double quantity = InputValidator.getValidInteger("Enter the quantity of this material: ");
        double unitCost = InputValidator.getValidInteger("Enter the unit cost of this material: ");
        double transportCost = InputValidator.getValidInteger("Enter the transport cost for this material: ");
        double qualityCoefficient = InputValidator.getValidInteger("Enter the quality coefficient of this material (1.0 = standard, > 1.0 = high quality): ");
        Materiel materiel = new Materiel(name, TypeComposant.MATERIEL, 0.2, unitCost, quantity, transportCost, qualityCoefficient, projet);
        composantsService.addComposant(materiel);
        boolean answer = InputValidator.getYesNoInput(" contunie y/n");
        if (answer) {
            new MaterielMenu(projet).start();
        }
        new MaindoeuvreMenu(materiel).start();

    }

    @Override
    public void printMenuHeader() {
        System.out.println("=== Add Materials ===");
    }
}

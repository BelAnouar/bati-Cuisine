package org.baticuisine.gui.impl;

import org.baticuisine.entities.Composants;
import org.baticuisine.entities.MainOeuvre;

import org.baticuisine.enums.TypeComposant;
import org.baticuisine.gui.Menu;
import org.baticuisine.services.ComposantsService;
import org.baticuisine.services.impl.ComposantsServiceInmpl;
import org.baticuisine.utils.InputValidator;

public class MaindoeuvreMenu implements Menu {
    private Composants composants;
    private ComposantsService composantsService;
    public MaindoeuvreMenu(Composants composants) {
        this.composants = composants;
        composantsService=new ComposantsServiceInmpl();
    }
    @Override
    public void start() {
        printMenuHeader();
        String type = InputValidator.getValidString("Enter the type of labor (e.g., Ouvrier de base, Spécialiste): ");
        double hourlyRate = InputValidator.getValidInteger("Enter the hourly rate of this labor (€/h): ");
        double hoursWorked = InputValidator.getValidInteger("Enter the number of hours worked: ");
        double productivityFactor = InputValidator.getValidInteger("Enter the productivity factor (1.0 = standard, > 1.0 = high productivity): ");
        MainOeuvre mainOeuvre = new MainOeuvre(composants.getNom(), TypeComposant.MAIN_DOEUVRE, 0.2, hourlyRate, hoursWorked, productivityFactor, composants.getProjet());
        composantsService.addComposant(mainOeuvre);
        boolean answer = InputValidator.getYesNoInput(" contunie y/n");
        if (answer) {
            new MaindoeuvreMenu(composants).start();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("=== Add Labor ===");
    }
}

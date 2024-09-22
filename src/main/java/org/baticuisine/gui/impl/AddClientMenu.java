package org.baticuisine.gui.impl;

import org.baticuisine.entities.Client;
import org.baticuisine.gui.Menu;
import org.baticuisine.services.ClientService;
import org.baticuisine.services.impl.ClientServiceImpl;
import org.baticuisine.utils.InputValidator;

import static org.baticuisine.utils.loggerUtil.info;

public class AddClientMenu implements Menu {
   private ClientService clientService;
    {
        clientService = new ClientServiceImpl();
    }
    @Override
    public void start() {
        printMenuHeader();
        String nom = InputValidator.getValidString("Enter client name: ");
        String adresse = InputValidator.getValidString("Enter client address: ");
        String telephone = InputValidator.getValidString("Enter client phone number (10 digits): ");
        boolean estProfessionnel = InputValidator.getYesNoInput("Is this a professional client? yes or No");
        Client client = new Client(nom, adresse, telephone, estProfessionnel);
        clientService.createClient(client);

        boolean answer = InputValidator.getYesNoInput("Would you like to continue with this client? (y/n):");
        if(answer){
            new AddProjectDetailsMenu(client).start();
        }
        new CreateProjectMenu().start();
    }

    @Override
    public void printMenuHeader() {
        info("=== Add New Client ===");
    }
}

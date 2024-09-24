package org.baticuisine.gui.impl;

import org.baticuisine.entities.Client;
import org.baticuisine.gui.Menu;
import org.baticuisine.services.ClientService;
import org.baticuisine.services.impl.ClientServiceImpl;
import org.baticuisine.utils.InputValidator;

import static org.baticuisine.utils.loggerUtil.info;


public class SearchClientMenu implements Menu {

    private ClientService clientService;
    {
        clientService = new ClientServiceImpl();
    }
    @Override
    public void start() {
        printMenuHeader();
        String name= InputValidator.getValidString("Enter Client Name: ");
        Client client= clientService.getClient(name);
        info(client.toString());
        boolean answer = InputValidator.getYesNoInput("Would you like to continue with this client? (y/n):");
        if(answer){
            new AddProjectDetailsMenu(client).start();
        }
        new MainMenu().start();
    }

    @Override
    public void printMenuHeader() {
       info("==== Search Client ====");
    }
}

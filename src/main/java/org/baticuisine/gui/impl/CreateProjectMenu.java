package org.baticuisine.gui.impl;

import org.baticuisine.gui.Menu;

import java.util.Scanner;

import static org.baticuisine.utils.loggerUtil.info;

public  class CreateProjectMenu implements Menu {
    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        info("1. Search for existing client");
        info("2. Add new client");
        info("Choose an option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                new SearchClientMenu().start();
                break;
            case 2:
                new AddClientMenu().start();
                break;
            default:
                info("Invalid option. Please try again.");
                start();
        }
    }

    @Override
    public void printMenuHeader() {
        info("=== Create New Project ===");
    }
}
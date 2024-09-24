package org.baticuisine.gui.impl;

import org.baticuisine.gui.Menu;

import java.util.Scanner;

import static org.baticuisine.utils.loggerUtil.info;

public class MainMenu implements Menu {


    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        info("1. Create a new project");
        info("2. Display existing projects");
        info("3. Calculate project cost");
        info("4. Quit");
        info("Choose an option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                new CreateProjectMenu().start();
                break;
            case 2:
                new DisplayProjectsMenu().start();
                break;
            case 3:
                new CalculateProjectCostMenu(null).start();
                break;
            case 4:
                info("Thank you for using Bati-Cuisine. Goodbye!");
                System.exit(0);
            default:
                info("Invalid option. Please try again.");
                start();
        }
    }

    @Override
    public void printMenuHeader() {
        info("=== Bati-Cuisine Project Management System ===");
        info("=== Main Menu ===");
    }
}

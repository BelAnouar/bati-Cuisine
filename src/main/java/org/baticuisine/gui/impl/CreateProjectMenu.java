package org.baticuisine.gui.impl;

import org.baticuisine.gui.Menu;

import java.util.Scanner;

public  class CreateProjectMenu implements Menu {
    @Override
    public void start() {
        printMenuHeader();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Search for existing client");
        System.out.println("2. Add new client");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                new SearchClientMenu().start();
                break;
            case 2:
                new AddClientMenu().start();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                start();
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("=== Create New Project ===");
    }
}
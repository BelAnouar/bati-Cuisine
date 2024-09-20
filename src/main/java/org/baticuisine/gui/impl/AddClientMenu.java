package org.baticuisine.gui.impl;

import org.baticuisine.gui.Menu;

public class AddClientMenu implements Menu {

    @Override
    public void start() {
        printMenuHeader();



    }

    @Override
    public void printMenuHeader() {
        System.out.println("=== Add New Client ===");
    }
}

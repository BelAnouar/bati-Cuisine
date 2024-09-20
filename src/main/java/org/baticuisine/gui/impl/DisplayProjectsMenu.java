package org.baticuisine.gui.impl;

import org.baticuisine.gui.Menu;

public class DisplayProjectsMenu implements Menu {
    @Override
    public void start() {
        printMenuHeader();

    }

    @Override
    public void printMenuHeader() {
        System.out.println("=== Display Existing Projects ===");
    }
}
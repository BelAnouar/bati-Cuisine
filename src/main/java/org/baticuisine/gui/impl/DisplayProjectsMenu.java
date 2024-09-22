package org.baticuisine.gui.impl;

import org.baticuisine.gui.Menu;

import static org.baticuisine.utils.loggerUtil.info;

public class DisplayProjectsMenu implements Menu {
    @Override
    public void start() {
        printMenuHeader();

    }

    @Override
    public void printMenuHeader() {
        info("=== Display Existing Projects ===");
    }
}
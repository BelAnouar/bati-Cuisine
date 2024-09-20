package org.baticuisine.utils;

import java.util.Scanner;

import static org.baticuisine.utils.loggerUtil.error;

public class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);
    public static String getValidString() {
        String input;
        do {
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
               error("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int getValidInteger() {
        while (true) {

            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                error("Invalid input. Please enter a valid integer.");
            }
        }
    }
}

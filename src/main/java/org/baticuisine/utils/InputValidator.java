package org.baticuisine.utils;

import org.baticuisine.enums.Etat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import java.util.Scanner;

import static org.baticuisine.utils.loggerUtil.error;
import static org.baticuisine.utils.loggerUtil.info;

public  class InputValidator {

    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    InputValidator(){}
    public static String getValidString(String prompt) {
        String input;
        do {
            info(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty() ) {
               error("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    public static int getValidInteger(String prompt) {
        while (true) {
            info(prompt);
            String input = scanner.nextLine();
            try {

                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                error("Invalid input. Please enter a valid integer.");
            }
        }
    }
    public static double getValidDouble(String prompt) {
        while (true) {
            info(prompt);
            String input = scanner.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                error("Invalid input. Please enter a valid decimal number.");
            }
        }
    }


    public static boolean getYesNoInput(String prompt) {
        while (true) {
            info(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                return false;
            }
            error("Invalid input. Please enter 'y' for yes or 'n' for no.");
        }
    }

    public static Etat getEtat(String prompt) {
        info(prompt);
        String input = scanner.nextLine().trim().toLowerCase();
        return switch (input) {
            case "termine" -> Etat.Terminé;
            case "en cours" -> Etat.Encours;
            case "annule" -> Etat.Annulé;

            default -> {
                error(" Etat invalide");
                Etat etat = getEtat(prompt);
                yield etat;
            }
        };
    }

    public static LocalDate getValidDate(String prompt) {
        LocalDate date = null;

        while (date == null) {
            info(prompt);
            String input = scanner.nextLine();
            try {
                date = LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                error("Invalid date format. Please enter the date in the format yyyy-MM-dd.");
            }
        }

        return date;
    }
}

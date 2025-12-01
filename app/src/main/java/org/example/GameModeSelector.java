package org.example;

import java.util.Scanner;

public class GameModeSelector {

    public enum Mode {
        HUMAN_VS_HUMAN,
        HUMAN_VS_COMPUTER,
        COMPUTER_VS_HUMAN
    }

    private final Scanner scanner;

    public GameModeSelector(Scanner scanner) {
        this.scanner = scanner;
    }

    public Mode chooseMode() {
        while (true) {
            System.out.println("\nWhat kind of game would you like to play?");
            System.out.println("1. Human vs. Human");
            System.out.println("2. Human vs. Computer");
            System.out.println("3. Computer vs. Human");
            System.out.print("\nWhat is your selection? ");

            String input = scanner.nextLine().trim();

            switch (input) {
                case "1": return Mode.HUMAN_VS_HUMAN;
                case "2": return Mode.HUMAN_VS_COMPUTER;
                case "3": return Mode.COMPUTER_VS_HUMAN;
                default:
                    System.out.println("Invalid selection. Try again.");
            }
        }
    }
}

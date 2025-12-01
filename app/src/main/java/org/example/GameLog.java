package org.example;

import java.io.FileWriter;
import java.io.IOException;

public class GameLog {
    private int xWins;
    private int oWins;
    private int ties;

    public void recordWin(char winner) {
        if (winner == 'X') xWins++;
        else if (winner == 'O') oWins++;
        else if (winner == 'T') ties++;
    }

    public void printLog() {
        System.out.println("The current log is:\n");
        System.out.printf("Player X Wins   %d%n", xWins);
        System.out.printf("Player O Wins   %d%n", oWins);
        System.out.printf("Ties            %d%n%n", ties);
    }

    public void saveToFile() {
        try (FileWriter writer = new FileWriter("game.txt")) {
            writer.write("Tic-Tac-Toe Game Log\n");
            writer.write("====================\n");
            writer.write(String.format("Player X Wins: %d%n", xWins));
            writer.write(String.format("Player O Wins: %d%n", oWins));
            writer.write(String.format("Ties: %d%n", ties));
            writer.write("====================\n");
            System.out.println("Writing the game log to file. Please see game.txt for the final stats!");
        } catch (IOException e) {
            System.out.println("Error writing game log to file: " + e.getMessage());
        }
    }

    public int getXWins() { return xWins; }
    public int getOWins() { return oWins; }
    public int getTies() { return ties; }
}

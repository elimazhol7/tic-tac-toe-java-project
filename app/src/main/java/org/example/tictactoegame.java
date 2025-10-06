package org.example;

import java.util.Scanner;

public class tictactoegame {
    private final board board;
    private char currentPlayer;
    private final Scanner scanner;

    public tictactoegame() {
        board = new board();
        currentPlayer = 'X';
        scanner = new Scanner(System.in);
    }

    public void play() {
        System.out.println("Welcome to Tic-Tac-Toe!");

        boolean playAgain;
        do {
            board.reset();
            currentPlayer = 'X';
            playSingleGame();
            playAgain = askReplay();
        } while (playAgain);

        System.out.println("Goodbye!");
    }

    private void playSingleGame() {
        while (true) {
            printBoard();
            int move = getPlayerMove();
            board.setCell(move - 1, currentPlayer);

            if (board.checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            } else if (board.isFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }

    private int getPlayerMove() {
        int move = -1;
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move: ");
            String input = scanner.nextLine().trim();
            try {
                move = Integer.parseInt(input);
                if (move < 1 || move > 9) {
                    System.out.println("That is not a valid move! Try again.");
                } else if (!board.isCellEmpty(move - 1)) {
                    System.out.println("That cell is already taken! Try again.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("That is not a valid move! Try again.");
            }
        }
        return move;
    }

    private void printBoard() {
        char[] c = board.getCells();
        System.out.println();
        System.out.println(" " + c[0] + " | " + c[1] + " | " + c[2]);
        System.out.println("---+---+---");
        System.out.println(" " + c[3] + " | " + c[4] + " | " + c[5]);
        System.out.println("---+---+---");
        System.out.println(" " + c[6] + " | " + c[7] + " | " + c[8]);
        System.out.println();
    }

    private boolean askReplay() {
        while (true) {
            System.out.print("Would you like to play again (yes/no)? ");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes")) return true;
            else if (input.equals("no")) return false;
            else System.out.println("That is not a valid entry!");
        }
    }
}

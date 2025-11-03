package org.example;

import java.util.Scanner;

public class TicTacToeGame {
    private final Board board;
    private char currentPlayer;
    private final Scanner scanner;
    private final GameLog gameLog;

    public TicTacToeGame() {
        board = new Board();
        currentPlayer = 'X';
        scanner = new Scanner(System.in);
        gameLog = new GameLog();
    }

    public GameLog getGameLog() {
        return gameLog;
    }

    public void play() {
        System.out.println("Welcome to Tic-Tac-Toe!");

        char lastLoser = ' ';
        boolean playAgain;

        do {
            board.reset();
            if (lastLoser == 'X' || lastLoser == 'O') {
                currentPlayer = lastLoser;
                System.out.println("Player " + currentPlayer + " starts this game.");
            } else {
                currentPlayer = 'X';
            }

            char result = playSingleGame();
            gameLog.recordWin(result);

            if (result == 'X') lastLoser = 'O';
            else if (result == 'O') lastLoser = 'X';
            else lastLoser = ' ';

            gameLog.printLog();
            playAgain = askReplay();

        } while (playAgain);

        gameLog.saveToFile();
        System.out.println("Goodbye!");
    }

    private char playSingleGame() {
        while (true) {
            printBoard();
            int move = getPlayerMove();
            board.setCell(move - 1, currentPlayer);

            if (board.checkWin(currentPlayer)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                return currentPlayer;
            } else if (board.isFull()) {
                printBoard();
                System.out.println("It's a draw!");
                return 'T';
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

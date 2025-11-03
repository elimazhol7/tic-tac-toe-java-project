package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameTest {

    private TicTacToeGame createGameWithInput(String input) {
        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        TicTacToeGame game = new TicTacToeGame();
        return game;
    }

    @Test
    void testXWinsGame() {
        // X wins on top row: 1,2,3; O moves 4,5
        String input = "1\n4\n2\n5\n3\nno\n";
        TicTacToeGame game = createGameWithInput(input);

        game.play();

        GameLog log = game.getGameLog();
        assertEquals(1, log.getXWins());
        assertEquals(0, log.getOWins());
        assertEquals(0, log.getTies());
    }

    @Test
    void testOWinsGame() {
        // O wins on top row: X moves 1,2,5; O moves 3,6,9
        String input = "1\n3\n2\n6\n5\n9\nno\n";
        TicTacToeGame game = createGameWithInput(input);

        game.play();

        GameLog log = game.getGameLog();
        assertEquals(0, log.getXWins());
        assertEquals(1, log.getOWins());
        assertEquals(0, log.getTies());
    }

    @Test
    void testTieGame() {
        // Moves lead to a tie
        String input = "1\n2\n3\n5\n4\n6\n8\n7\n9\nno\n";
        TicTacToeGame game = createGameWithInput(input);

        game.play();

        GameLog log = game.getGameLog();
        assertEquals(0, log.getXWins());
        assertEquals(0, log.getOWins());
        assertEquals(1, log.getTies());
    }

    @Test
    void testMultipleGames() {
        // Play two games in a row, first X wins, second tie
        String input = "1\n4\n2\n5\n3\nyes\n" +  // X wins
                       "1\n2\n3\n5\n4\n6\n8\n7\n9\nno\n"; // Tie
        TicTacToeGame game = createGameWithInput(input);

        game.play();

        GameLog log = game.getGameLog();
        assertEquals(1, log.getXWins());
        assertEquals(0, log.getOWins());
        assertEquals(1, log.getTies());
    }
}
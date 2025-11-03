package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogTest {

    private GameLog gameLog;

    @BeforeEach
    void setUp() {
        gameLog = new GameLog();
    }

    @Test
    void testInitialCounts() {
        assertEquals(0, gameLog.getXWins(), "X wins should start at 0");
        assertEquals(0, gameLog.getOWins(), "O wins should start at 0");
        assertEquals(0, gameLog.getTies(), "Ties should start at 0");
    }

    @Test
    void testRecordXWin() {
        gameLog.recordWin('X');
        assertEquals(1, gameLog.getXWins());
        assertEquals(0, gameLog.getOWins());
        assertEquals(0, gameLog.getTies());
    }

    @Test
    void testRecordOWin() {
        gameLog.recordWin('O');
        assertEquals(0, gameLog.getXWins());
        assertEquals(1, gameLog.getOWins());
        assertEquals(0, gameLog.getTies());
    }

    @Test
    void testRecordTie() {
        gameLog.recordWin('T');
        assertEquals(0, gameLog.getXWins());
        assertEquals(0, gameLog.getOWins());
        assertEquals(1, gameLog.getTies());
    }

    @Test
    void testMultipleRecords() {
        gameLog.recordWin('X');
        gameLog.recordWin('O');
        gameLog.recordWin('X');
        gameLog.recordWin('T');
        gameLog.recordWin('O');
        gameLog.recordWin('T');

        assertEquals(2, gameLog.getXWins());
        assertEquals(2, gameLog.getOWins());
        assertEquals(2, gameLog.getTies());
    }

    @Test
    void testPrintLogDoesNotThrow() {
        // Just ensure printLog runs without exceptions
        assertDoesNotThrow(() -> gameLog.printLog());
    }
}

package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class boardtest {
    private board board;

    @BeforeEach
    public void setUp() {
        board = new board();
    }

    @Test
    public void testInitialBoardNotFull() {
        assertFalse(board.isFull());
    }

    @Test
    public void testSetCell() {
        assertTrue(board.setCell(0, 'X'));
        assertEquals('X', board.getCells()[0]);
        assertFalse(board.setCell(0, 'O')); // cannot overwrite
    }

    @Test
    public void testCheckWinRow() {
        board.setCell(0, 'X');
        board.setCell(1, 'X');
        board.setCell(2, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testCheckWinColumn() {
        board.setCell(0, 'O');
        board.setCell(3, 'O');
        board.setCell(6, 'O');
        assertTrue(board.checkWin('O'));
    }

    @Test
    public void testCheckWinDiagonal() {
        board.setCell(0, 'X');
        board.setCell(4, 'X');
        board.setCell(8, 'X');
        assertTrue(board.checkWin('X'));
    }

    @Test
    public void testBoardFull() {
        for (int i = 0; i < 9; i++) {
            board.setCell(i, 'X');
        }
        assertTrue(board.isFull());
    }
}


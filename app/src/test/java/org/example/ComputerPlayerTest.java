package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComputerPlayerTest {

    @Test
    void testComputerMoveIsValid() {
        Board board = new Board();
        ComputerPlayer ai = new ComputerPlayer();

        int move = ai.chooseMove(board, 'X', 0); // first move
        assertTrue(move >= 0 && move <= 8, "Computer move should be between 0 and 8");
        assertTrue(board.isCellEmpty(move), "Chosen cell should be empty");
    }

    @Test
    void testComputerBlocksWinningMove() {
        Board board = new Board();
        ComputerPlayer ai = new ComputerPlayer();

        // Human is 'O' and about to win
        board.setCell(0, 'O');
        board.setCell(1, 'O');
        // Computer is 'X'
        board.setCell(4, 'X');

        int move = ai.chooseMove(board, 'X', 2); // AI's 3rd turn
        assertEquals(2, move, "Computer should block at index 2");
    }
}

package org.example;

import java.util.*;

public class ComputerPlayer {

    private final Random rand = new Random();

    public int chooseMove(Board board, char computer, int turnNumber) {
        char opponent = (computer == 'X') ? 'O' : 'X';

        // RULE 1 — First move → corner
        if (turnNumber == 0) {
            int[] corners = {0, 2, 6, 8};
            return corners[rand.nextInt(4)];
        }

        // RULE 2 — Second move → center if empty
        if (turnNumber == 1 && board.isCellEmpty(4)) {
            return 4;
        }

        // RULE 3 — Try to win
        for (int i = 0; i < 9; i++) {
            if (board.isCellEmpty(i)) {
                board.forceSet(i, computer);
                if (board.checkWin(computer)) {
                    board.forceSet(i, (char) ('1' + i)); // undo
                    return i;
                }
                board.forceSet(i, (char) ('1' + i));
            }
        }

        // RULE 4 — Block opponent
        for (int i = 0; i < 9; i++) {
            if (board.isCellEmpty(i)) {
                board.forceSet(i, opponent);
                if (board.checkWin(opponent)) {
                    board.forceSet(i, (char) ('1' + i));
                    return i;
                }
                board.forceSet(i, (char) ('1' + i));
            }
        }

        // RULE 5 — Random
        List<Integer> open = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (board.isCellEmpty(i)) open.add(i);
        }
        return open.get(rand.nextInt(open.size()));
    }
}

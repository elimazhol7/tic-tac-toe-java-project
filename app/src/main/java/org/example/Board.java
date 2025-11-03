package org.example;

public class Board {
    private final char[] cells = new char[9];

    public Board() {
        reset();
    }

    public void reset() {
        for (int i = 0; i < 9; i++) {
            cells[i] = (char) ('1' + i);
        }
    }

    public boolean isCellEmpty(int index) {
        return cells[index] != 'X' && cells[index] != 'O';
    }

    public boolean setCell(int index, char player) {
        if (index < 0 || index > 8 || !isCellEmpty(index)) {
            return false;
        }
        cells[index] = player;
        return true;
    }

    public char[] getCells() {
        return cells.clone();
    }

    public boolean isFull() {
        for (char c : cells) {
            if (c != 'X' && c != 'O') return false;
        }
        return true;
    }

    public boolean checkWin(char player) {
        int[][] winPositions = {
                {0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
        };
        for (int[] pos : winPositions) {
            if (cells[pos[0]] == player && cells[pos[1]] == player && cells[pos[2]] == player) {
                return true;
            }
        }
        return false;
    }
}


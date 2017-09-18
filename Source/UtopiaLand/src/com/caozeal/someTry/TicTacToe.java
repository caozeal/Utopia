package com.caozeal.someTry;

public class TicTacToe {

    private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
    char lastPlayer = '\0';
    private int steps = 0;

    public String play(int x, int y) {
        check(x, y);
        lastPlayer = nextPlayer();
        setBox(x, y);
        if (isWin(x, y)) {
            return "Winner is " + lastPlayer;
        }
        if (steps == 9) {
            return "The result is draw";
        }
        return "No winner";
    }

    private void check(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        checkOccupied(x, y);
    }

    private boolean isWin(int x, int y) {
        char horizontal, vertical, diagonal1, diagonal2;
        horizontal = vertical = diagonal1 = diagonal2 = '\0';
        for (int i = 0; i < 3; i++) {
            horizontal += board[i][y - 1];
            vertical += board[x - 1][i];
            diagonal1 += board[i][2 - i];
            diagonal2 += board[i][i];
        }
        return horizontal == lastPlayer * 3
                   || vertical == lastPlayer * 3
                   || diagonal1 == lastPlayer * 3
                   || diagonal2 == lastPlayer * 3;
    }

    private void setBox(int x, int y) {
        board[x - 1][y - 1] = lastPlayer;
        steps++;
    }

    private void checkOccupied(int x, int y) {
        if (board[x - 1][y - 1] != '\0') {
            throw new RuntimeException("Box is occupied!");
        }
    }

    private void checkAxis(int axis) {
        if (axis > 3 || axis < 1) {
            throw new RuntimeException("X is outside board!");
        }
    }

    char nextPlayer() {
        if (this.lastPlayer == 'X') {
            return 'O';
        }
        return 'X';
    }
}

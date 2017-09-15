package com.caozeal.someTry;

public class TicTacToe {

    private Character[][] board = {{'\0','\0','\0'},{'\0','\0','\0'},{'\0','\0','\0'}};
    public char lastPlayer = '\0';

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x, y);
        lastPlayer = nextPlayer();
        if (isWin(x, y)) {
            return "Winner is " + lastPlayer;
        }
        return "No winner";
    }

    private boolean isWin(int x, int y) {
        boolean occupiedHorizonLine = board[0][y - 1] + board[1][y - 1] + board[2][y - 1] == lastPlayer * 3;
        boolean occupiedVerticalLine = board[x - 1][0] + board[x - 1][1] + board[x - 1][2] == lastPlayer * 3;
        return occupiedHorizonLine || occupiedVerticalLine;
    }

    private void setBox(int x, int y) {
        if(board[x-1][y-1] != '\0'){
            throw new RuntimeException("Box is occupied!");
        }
        board[x-1][y-1] = 'X';
    }

    private void checkAxis(int axis) {
        if(axis > 3 || axis < 1){
            throw new RuntimeException("X is outside board!");
        }
    }

    public char nextPlayer() {
        if(this.lastPlayer == 'X'){
            return 'O';
        }
        return 'X';
    }
}

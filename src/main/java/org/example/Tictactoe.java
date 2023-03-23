package org.example;

public class Tictactoe {

    private char[] board = new char[9];

    public boolean isBoardEmpty() {
        return true;
    }

    public Tictactoe playerMakesTurn(char player, int coordinate) {
        Tictactoe tictactoe = new Tictactoe();
        tictactoe.board[coordinate] = player;
        return tictactoe;
    }
}

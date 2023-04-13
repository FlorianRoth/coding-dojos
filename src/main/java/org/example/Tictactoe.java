package org.example;

import java.util.Arrays;
import java.util.Objects;

public class Tictactoe {

    private Character[] board = new Character[9];

    public boolean isBoardEmpty() {
        var boardStream = Arrays.stream(board);
        return boardStream.allMatch(Objects::isNull);
    }

    public Tictactoe playerMakesTurn(char player, int coordinate) {
        Tictactoe tictactoe = new Tictactoe();
        tictactoe.board[coordinate] = player;
        return tictactoe;
    }
}

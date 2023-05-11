package org.example;

import java.util.Arrays;
import java.util.Objects;

public class Board {

    private final Tictactoe.Player[] board;

    public Board(){
        this.board = new Tictactoe.Player[9];
    }

    private Board(Board board) {
        this.board = board.board;
    }

    public boolean isBoardEmpty() {
        var boardStream = Arrays.stream(board);
        return boardStream.allMatch(Objects::isNull);
    }

    public boolean isOccupied(int coordinate){
        return board[coordinate] != null;
    }

    public Board playerMakesTurn(Tictactoe.Player player, int coordinate) {
        var newBoard = new Board(this);
        newBoard.board[coordinate] = player;
        return newBoard;
    }

    public Tictactoe.Player retrieveMarkFromCoordinate(int coordinate) {
        return board[coordinate];
    }
}

package org.example;

import java.util.Arrays;
import java.util.Objects;

public class Tictactoe {

    private final Board board;

    private final Player lastActor;

    public enum Player{
        X,O
    }

    public Tictactoe() {
        this.board = new Board();
        this.lastActor = null;
    }

    private Tictactoe(Player[] board, Player lastActor) {
        this.board = Arrays.copyOf(board, board.length);
        this.lastActor = lastActor;
    }

    public boolean isBoardEmpty() {
        var boardStream = Arrays.stream(board);
        return boardStream.allMatch(Objects::isNull);
    }

    public Tictactoe playerMakesTurn(Player player, int coordinate) {

        if(board[coordinate] != null){
            throw new IllegalArgumentException("Dieses Feld ist schon besetzt!");
        }

        if(this.lastActor == player){
            throw new IllegalArgumentException("Dieser Spieler ist nicht an der Reihe!");
        }

        Tictactoe tictactoe = new Tictactoe(board, player);
        tictactoe.board[coordinate] = player;

        return tictactoe;
    }

    public Player retrieveMarkFromCoordinate(int coordinate) {
        return board[coordinate];
    }

    public Player getWinner(){

    }

}

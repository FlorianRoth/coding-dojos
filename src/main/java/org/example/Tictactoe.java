package org.example;

import java.util.Arrays;
import java.util.Objects;

public class Tictactoe {

    private Player[] board = new Player[9];

    private Player lastActor;

    public enum Player{
        X,O
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

        Tictactoe tictactoe = new Tictactoe();
        tictactoe.board[coordinate] = player;
                
        tictactoe.lastActor = player;

        return tictactoe;
    }
}

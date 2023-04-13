package org.example;

import java.util.Arrays;
import java.util.Objects;

public class Tictactoe {

    private Player[] board = new Player[9];

    private Player currentActor;

    public enum Player{
        X,O
    }

    public boolean isBoardEmpty() {
        var boardStream = Arrays.stream(board);
        return boardStream.allMatch(Objects::isNull);
    }

    public Tictactoe playerMakesTurn(Player player, int coordinate) {

        if(board[coordinate] != null){
            throw new IllegalArgumentException();
        }



        Tictactoe tictactoe = new Tictactoe();
        tictactoe.board[coordinate] = player;
        
        
        tictactoe.currentActor = Player.X;
        if(player ==  Player.X)
            tictactoe.currentActor = Player.O;

        return tictactoe;
    }
}

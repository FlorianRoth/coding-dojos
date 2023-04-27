package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Tictactoe.Player;

class TictactoeTest {

    @Test
    public void whenGameInitialized_GameBoardIsDefined() {
        var game = new Tictactoe();

        assertTrue(game.isBoardEmpty());
    }

    @Test
    public void whenPlayerXMakesFirstTurn_BoardIsNotEmptyAnymore() {
        var game = new Tictactoe();
        var playerX = Player.X;
        var coord = 5;
        Tictactoe newTurn = game.playerMakesTurn(playerX, coord);
        assertFalse(newTurn.isBoardEmpty());
    }

    @Test
    public void whenPlayerTriesToOverride()
    {
        var game = new Tictactoe();
        var playerX = Player.X;
        var coord = 5;
        Tictactoe newTurn = game.playerMakesTurn(playerX, coord);
        
        assertThrows(IllegalArgumentException.class, ()-> newTurn.playerMakesTurn(playerX, coord));
    }

    @Test
    public void playerCannotMakeTwocConsecutiveMoves()
    {
        var game = new Tictactoe().playerMakesTurn(Player.X, 0);
        
        assertThrows(IllegalArgumentException.class, ()->game.playerMakesTurn(Player.X, 1));
        
    }

}
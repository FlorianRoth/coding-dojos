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
        
        var exception = assertThrows(IllegalArgumentException.class, ()-> newTurn.playerMakesTurn(playerX, coord));
        assertEquals("Dieses Feld ist schon besetzt!", exception.getMessage(), "Das war die falsche Fehlermeldung");
        
    }

    @Test
    public void playerCannotMakeTwocConsecutiveMoves()
    {
        var game = new Tictactoe().playerMakesTurn(Player.X, 0);
        
        var exception = assertThrows(IllegalArgumentException.class, ()->game.playerMakesTurn(Player.X, 1));
        assertEquals("Dieser Spieler ist nicht an der Reihe!", exception.getMessage(), "Das war die falsche Fehlermeldung");
    }

}
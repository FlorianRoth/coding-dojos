package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TictactoeTest {

    @Test
    public void whenGameInitialized_GameBoardIsDefined() {
        var game = new Tictactoe();
        
        assertEquals(true, game.isBoardEmpty());
    }

    @Test
    public void whenPlayerXMakesFirstTurn_BoardIsNotEmptyAnymore() {
        var game = new Tictactoe();
        var playerX = 'X';
        var coord = 5;
        game.playerMakesTurn(playerX, coord);
        assertEquals(true, game.isBoardEmpty());
    }
}
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TictactoeTest {

    @Test
    public void whenGameInitialized_GameBoardIsDefined() {
        var game = new Tictactoe();

        assertTrue(game.isBoardEmpty());
    }

    @Test
    public void whenPlayerXMakesFirstTurn_BoardIsNotEmptyAnymore() {
        var game = new Tictactoe();
        var playerX = 'X';
        var coord = 5;
        Tictactoe newTurn = game.playerMakesTurn(playerX, coord);
        assertFalse(newTurn.isBoardEmpty());
    }
}
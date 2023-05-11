package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoardTest {
    
    @Test
    public void whenBoardInitialized_GameBoardIsDefined() {
        var board = new Board();

        assertTrue(board.isBoardEmpty());
    }

    @Test
    public void whenPlayerXMakesFirstTurn_BoardIsNotEmptyAnymore() {
        var game = new Board();
        var playerX = Tictactoe.Player.X;
        var coord = 5;
        var newTurn = game.setMark(playerX, coord);
        assertFalse(newTurn.isBoardEmpty());
    }

    @Test
    public void whenCoordinateIsEmptyIsOccupiedShouldReturnFalse() {
        var board = new Board();

        assertFalse(board.isOccupied(1));
    }

    @Test
    public void whenCoordinateIsSetIsOccupiedShouldReturnTrue() {
        var board = new Board()
        .setMark(Tictactoe.Player.X, 1);

        assertTrue(board.isOccupied(1));
    }

    @Test
    public void whenCoordinateIsSetRetrieveMarkShouldReturnPlayer() {
        var playerX = Tictactoe.Player.X;
        var board = new Board()
        .setMark(playerX, 1);

        assertEquals(playerX, board.retrieveMarkFromCoordinate(1));
    }
}

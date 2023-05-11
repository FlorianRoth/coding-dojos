package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BoardTest {
    
    @Test
    public void whenBoardInitialized_GameBoardIsDefined() {
        var board = new Board();

        assertTrue(board.isBoardEmpty());
    }
}

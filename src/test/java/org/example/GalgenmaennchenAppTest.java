package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class GalgenmaennchenAppTest {
    private Console mock = Mockito.mock(Console.class);

    @Test
    public void shouldAskForWord() {
        new GalgenmaennchenApp(mock).startGame();
        Mockito.verify(mock).writeLine("Bitte Wort eingeben");
    }

    @Test
    public void shouldStartGameWithEnteredWord() {
        Mockito.when(mock.readLine()).thenReturn("Florian");
        new GalgenmaennchenApp(mock).startGame();
        Mockito.verify(mock).writeLine("Erste Runde -------");
    }
}

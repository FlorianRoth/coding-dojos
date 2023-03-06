package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GalgenmaennchenTest {

    @Test
    void rateBuchstabe_WrongChar_ShouldReturnOnlyDashes() {
        var cut = new Galgenmaennchen("Developer");

        var result = cut.rateBuchstabe('u');

        assertEquals("---------", result);
    }

    @Test
    void rateBuchstabe_RightChar_ShouldRevealCorrectCharacters() {
        var cut = new Galgenmaennchen("Developer");

        var result = cut.rateBuchstabe('e');

        assertEquals("-e-e---e-", result);
    }

    @Test
    void rateBuchstabe_WrongCharAfterRightChar_ShouldRevealOnlyCorrectCharacters() {
        var cut = new Galgenmaennchen("Developer");

        var result1 = cut.rateBuchstabe('e');
        var result2 = cut.rateBuchstabe('n');

        assertEquals(result1, result2);
    }

    @Test
    void rateBuchstabe_lowerRightChar_ShouldRevealCharactersCaseInsensitive() {
        var cut = new Galgenmaennchen("Developer");

        var result = cut.rateBuchstabe('d');

        assertEquals("D--------", result);
    }
}
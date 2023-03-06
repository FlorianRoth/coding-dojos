package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RomanTest {

    private Roman roman;

    @BeforeEach
    void setUp() {
        roman = new Roman();
    }

    @ParameterizedTest
    @CsvSource({"1,I","2,II", "4,IV", "7, VII", "9, IX", "10, X", "13, XIII", "14, XIV",
            "19,XIX", "24,XXIV", "28,XXVIII", "40,XL", "49,XLIX", "51,LI", "60,LX",
            "80,LXXX", "88,LXXXVIII", "90,XC", "91,XCI", "100,C", "468,CDLXVIII"})
    void returnsExpected(int input, String expected) {
        var result = roman.convert(input);
        assertEquals(expected, result);
    }

    @Test
    void zeroIsIllegal() {
        assertThrows(IllegalArgumentException.class, () -> roman.convert(0));
    }


}

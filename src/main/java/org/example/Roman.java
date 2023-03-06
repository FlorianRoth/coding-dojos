package org.example;

import static org.example.Roman.Numeral.*;

public class Roman {
    protected enum Numeral {
        I(1, 3),
        V(5, 1),
        X(10, 3),
        L(50, 1),
        C(100, 3),
        D(500, 1),
        M(1000, 3);

        private int numVal;
        private int repeatable;

        Numeral(int numVal, int repeatable) {
            this.numVal = numVal;
            this.repeatable = repeatable;
        }

        public int getNumVal() {
            return numVal;
        }

        public int getRepeatable() {
            return repeatable;
        }

        public String repeat(int times) {
            return name().repeat(times);
        }
    }

    record NextNumberResult(String resultString, int remainder) {
    }

    public String convert(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not allowed");
        }

        int numM = i / M.getNumVal();
        var result = M.repeat(numM);

        // Rest also remainerL zurückgeben
        NextNumberResult initial = new NextNumberResult(result, i);
        NextNumberResult newresult = createNextNumberString(initial, M, D, C);
        newresult = createNextNumberString(newresult, C, L, X);
        newresult = createNextNumberString(newresult, X, V, I);

        return newresult.resultString;
    }

    private static NextNumberResult createNextNumberString(NextNumberResult previousResult, Numeral big, Numeral middle, Numeral small) {
        String result = previousResult.resultString;
        int remainderBig = previousResult.remainder % big.getNumVal();
        int numMiddle = remainderBig / middle.getNumVal();
        int remainderMiddle = remainderBig % middle.getNumVal();
        int numSmall = remainderMiddle / small.getNumVal();
        if (numSmall > small.getRepeatable()) {
            if (numMiddle > 0) {
                result += small.name() + big.name();
            } else {
                result += small.name() + middle.name();
            }
        } else {
            result += middle.repeat(numMiddle) + small.repeat(numSmall);
        }
        return new NextNumberResult(result, remainderMiddle);
    }
}

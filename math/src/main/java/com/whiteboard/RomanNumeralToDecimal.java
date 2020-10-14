package com.whiteboard;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert a Roman numeral to decimal.
 */
public final class RomanNumeralToDecimal {
    private RomanNumeralToDecimal() {
    }

    /**
     * Converts a Roman numeral to decimal.
     *
     * We start at the end of the Roman numeral string, and
     * work toward the front. We look up each char's decimal
     * value in a hash table, and add it to a running total,
     * UNLESS the current char's value is less than the
     * previous char's value. In that case, we SUBTRACT the
     * current char's value from the running total.
     *
     * @param roman A string containing the Roman numeral to
     *              be converted to decimal.
     * @return The decimal equivalent of the given Roman numeral.
     */
    public static int romanNumeralToDecimal(String roman) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        char nextRomanDigit = roman.charAt(roman.length() - 1);
        int nextRomanDigitDecimalValue = map.get(nextRomanDigit);

        for (int i = roman.length() - 1; i >= 0; --i) {
            char currRomanDigit = roman.charAt(i);
            int currRomanDigitDecimalValue = map.get(currRomanDigit);
            if (currRomanDigitDecimalValue < nextRomanDigitDecimalValue) {
                result -= currRomanDigitDecimalValue;
            } else {
                result += currRomanDigitDecimalValue;
            }
            nextRomanDigitDecimalValue = currRomanDigitDecimalValue;
        }
        return result;
    }
}

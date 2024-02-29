package org.chnu.romantoarabic;

import java.util.HashMap;
import java.util.Map;

public final class RomanToArabicConverter {
    private static final Map<Character, Integer> romanValues = new HashMap<>();

    static {
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
    }

    public static int convert(String roman) {
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            if (i > 0 && romanValues.get(roman.charAt(i)) > romanValues.get(roman.charAt(i - 1))) {
                result += romanValues.get(roman.charAt(i)) - 2 * romanValues.get(roman.charAt(i - 1));
            } else {
                result += romanValues.get(roman.charAt(i));
            }
        }
        return result;
    }
}

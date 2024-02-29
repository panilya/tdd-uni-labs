package org.chnu.arabittoromanlab;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ArabicToRomanConverter {
    private static final LinkedHashMap<Integer, String> numberToRomanMap = new LinkedHashMap<>();

    static {
        numberToRomanMap.put(1000, "M");
        numberToRomanMap.put(900, "CM");
        numberToRomanMap.put(500, "D");
        numberToRomanMap.put(400, "CD");
        numberToRomanMap.put(100, "C");
        numberToRomanMap.put(90, "XC");
        numberToRomanMap.put(50, "L");
        numberToRomanMap.put(40, "XL");
        numberToRomanMap.put(10, "X");
        numberToRomanMap.put(9, "IX");
        numberToRomanMap.put(5, "V");
        numberToRomanMap.put(4, "IV");
        numberToRomanMap.put(1, "I");
    }

    public static String convertToRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("Number range is between 1 and 3999");
        }
        StringBuilder roman = new StringBuilder();
        for (Map.Entry<Integer, String> entry : numberToRomanMap.entrySet()) {
            while (number >= entry.getKey()) {
                roman.append(entry.getValue());
                number -= entry.getKey();
            }
        }
        return roman.toString();
    }
}

package org.chnu.arabittoromanlab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArabicToRomanConverterTests {

    @ParameterizedTest
    @CsvSource({
            "1, I",
            "2, II",
            "3, III",
            "4, IV",
            "5, V",
            "9, IX",
            "21, XXI",
            "50, L",
            "90, XC",
            "101, CI",
            "3999, MMMCMXCIX"
    })
    void convertsNumberToExpectedRomanNumeral(int number, String expectedRoman) {
        assertEquals(expectedRoman, ArabicToRomanConverter.convertToRoman(number));
    }

    @Test
    void testConvert1() {
        assertEquals("I", ArabicToRomanConverter.convertToRoman(1));
    }

    @Test
    void testConvert2() {
        assertEquals("II", ArabicToRomanConverter.convertToRoman(2));
    }

    @Test
    void testConvert3() {
        assertEquals("III", ArabicToRomanConverter.convertToRoman(3));
    }

    @Test
    void testConvert4() {
        assertEquals("IV", ArabicToRomanConverter.convertToRoman(4));
    }

    @Test
    void testConvert5() {
        assertEquals("V", ArabicToRomanConverter.convertToRoman(5));
    }

    @Test
    void testConvert9() {
        assertEquals("IX", ArabicToRomanConverter.convertToRoman(9));
    }

    @Test
    void testConvert27() {
        assertEquals("XXVII", ArabicToRomanConverter.convertToRoman(27));
    }

    @Test
    void testConvert50() {
        assertEquals("L", ArabicToRomanConverter.convertToRoman(50));
    }

    @Test
    void testConvert150() {
        assertEquals("CL", ArabicToRomanConverter.convertToRoman(150));
    }

    @Test
    void testConvert200() {
        assertEquals("CC", ArabicToRomanConverter.convertToRoman(200));
    }

    @Test
    void testConvert250() {
        assertEquals("CCL", ArabicToRomanConverter.convertToRoman(250));
    }

    @Test
    void testConvert352() {
        assertEquals("CCCLII", ArabicToRomanConverter.convertToRoman(352));
    }

    @Test
    void testConvert555() {
        assertEquals("DLV", ArabicToRomanConverter.convertToRoman(555));
    }

    @Test
    void testConvert777() {
        assertEquals("DCCLXXVII", ArabicToRomanConverter.convertToRoman(777));
    }

    @Test
    void testConvert3999() {
        assertEquals("MMMCMXCIX", ArabicToRomanConverter.convertToRoman(3999));
    }

    @Test
    void throwsExceptionForZero() {
        assertThrows(IllegalArgumentException.class, () -> ArabicToRomanConverter.convertToRoman(0));
    }

    @Test
    void throwsExceptionForNegativeNumbers() {
        assertThrows(IllegalArgumentException.class, () -> ArabicToRomanConverter.convertToRoman(-10));
    }

    @Test
    void throwsExceptionForNumbersOver3999() {
        assertThrows(IllegalArgumentException.class, () -> ArabicToRomanConverter.convertToRoman(4000));
    }

    @Test
    void testConvert40() {
        assertEquals("XL", ArabicToRomanConverter.convertToRoman(40));
    }

    @Test
    void testConvert44() {
        assertEquals("XLIV", ArabicToRomanConverter.convertToRoman(44));
    }

    @Test
    void testConvert99() {
        assertEquals("XCIX", ArabicToRomanConverter.convertToRoman(99));
    }

    @Test
    void testConvert100() {
        assertEquals("C", ArabicToRomanConverter.convertToRoman(100));
    }

    @Test
    void testConvert400() {
        assertEquals("CD", ArabicToRomanConverter.convertToRoman(400));
    }

    @Test
    void testConvert500() {
        assertEquals("D", ArabicToRomanConverter.convertToRoman(500));
    }

    @Test
    void testConvert900() {
        assertEquals("CM", ArabicToRomanConverter.convertToRoman(900));
    }

    @Test
    void testConvert1000() {
        assertEquals("M", ArabicToRomanConverter.convertToRoman(1000));
    }

    @Test
    void testConvert1984() {
        assertEquals("MCMLXXXIV", ArabicToRomanConverter.convertToRoman(1984));
    }

    @Test
    void testConvert2427() {
        assertEquals("MMCDXXVII", ArabicToRomanConverter.convertToRoman(2427));
    }

    @Test
    void testConvert3888() {
        assertEquals("MMMDCCCLXXXVIII", ArabicToRomanConverter.convertToRoman(3888));
    }

}

package org.chnu.romantoarabic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RomanToArabicConverterTests {

    @Test
    void convertI() {
        assertEquals(1, RomanToArabicConverter.convert("I"));
    }

    @Test
    void convertII() {
        assertEquals(2, RomanToArabicConverter.convert("II"));
    }

    @Test
    void convertIII() {
        assertEquals(3, RomanToArabicConverter.convert("III"));
    }

    @Test
    void convertIV() {
        assertEquals(4, RomanToArabicConverter.convert("IV"));
    }

    @Test
    void convertV() {
        assertEquals(5, RomanToArabicConverter.convert("V"));
    }

    @Test
    void convertVI() {
        assertEquals(6, RomanToArabicConverter.convert("VI"));
    }

    @Test
    void convertVII() {
        assertEquals(7, RomanToArabicConverter.convert("VII"));
    }

    @Test
    void convertVIII() {
        assertEquals(8, RomanToArabicConverter.convert("VIII"));
    }

    @Test
    void convertIX() {
        assertEquals(9, RomanToArabicConverter.convert("IX"));
    }

    @Test
    void convertX() {
        assertEquals(10, RomanToArabicConverter.convert("X"));
    }

    @Test
    void convertXI() {
        assertEquals(11, RomanToArabicConverter.convert("XI"));
    }

    @Test
    void convertXIV() {
        assertEquals(14, RomanToArabicConverter.convert("XIV"));
    }

    @Test
    void convertXV() {
        assertEquals(15, RomanToArabicConverter.convert("XV"));
    }

    @Test
    void convertXIX() {
        assertEquals(19, RomanToArabicConverter.convert("XIX"));
    }

    @Test
    void convertXX() {
        assertEquals(20, RomanToArabicConverter.convert("XX"));
    }

    @Test
    void convertXXX() {
        assertEquals(30, RomanToArabicConverter.convert("XXX"));
    }

    @Test
    void convertXL() {
        assertEquals(40, RomanToArabicConverter.convert("XL"));
    }

    @Test
    void convertL() {
        assertEquals(50, RomanToArabicConverter.convert("L"));
    }

    @Test
    void convertLX() {
        assertEquals(60, RomanToArabicConverter.convert("LX"));
    }

    @Test
    void convertLXX() {
        assertEquals(70, RomanToArabicConverter.convert("LXX"));
    }

    @Test
    void convertLXXX() {
        assertEquals(80, RomanToArabicConverter.convert("LXXX"));
    }

    @Test
    void convertXC() {
        assertEquals(90, RomanToArabicConverter.convert("XC"));
    }

    @Test
    void convertC() {
        assertEquals(100, RomanToArabicConverter.convert("C"));
    }

    @Test
    void convertCL() {
        assertEquals(150, RomanToArabicConverter.convert("CL"));
    }

    @Test
    void convertCC() {
        assertEquals(200, RomanToArabicConverter.convert("CC"));
    }

    @Test
    void convertDLV() {
        assertEquals(555, RomanToArabicConverter.convert("DLV"));
    }

    @Test
    void convertCD() {
        assertEquals(400, RomanToArabicConverter.convert("CD"));
    }

    @Test
    void convertD() {
        assertEquals(500, RomanToArabicConverter.convert("D"));
    }

    @Test
    void convertCM() {
        assertEquals(900, RomanToArabicConverter.convert("CM"));
    }

    @Test
    void convertM() {
        assertEquals(1000, RomanToArabicConverter.convert("M"));
    }

    @Test
    void convertMM() {
        assertEquals(2000, RomanToArabicConverter.convert("MM"));
    }

    @Test
    void convertMMM() {
        assertEquals(3000, RomanToArabicConverter.convert("MMM"));
    }

    @Test
    void convertMMMCMXCIX() {
        assertEquals(3999, RomanToArabicConverter.convert("MMMCMXCIX"));
    }

    @Test
    void convertCCXLVI() {
        assertEquals(246, RomanToArabicConverter.convert("CCXLVI"));
    }

    @Test
    void convertDCCLXXXIX() {
        assertEquals(789, RomanToArabicConverter.convert("DCCLXXXIX"));
    }

    @Test
    void convertMMCDXXI() {
        assertEquals(2421, RomanToArabicConverter.convert("MMCDXXI"));
    }

    @Test
    void convertCLX() {
        assertEquals(160, RomanToArabicConverter.convert("CLX"));
    }

    @Test
    void convertCCVII() {
        assertEquals(207, RomanToArabicConverter.convert("CCVII"));
    }

    @Test
    void convertMIX() {
        assertEquals(1009, RomanToArabicConverter.convert("MIX"));
    }

    @Test
    void convertMLXVI() {
        assertEquals(1066, RomanToArabicConverter.convert("MLXVI"));
    }

}

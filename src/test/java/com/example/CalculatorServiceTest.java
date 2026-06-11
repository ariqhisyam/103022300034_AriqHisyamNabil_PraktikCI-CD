package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("CalculatorService Tests")
class CalculatorServiceTest {

    private CalculatorService calculator;

    @BeforeEach
    void setUp() {
        calculator = new CalculatorService();
    }

    @Test
    @DisplayName("Penjumlahan dua bilangan positif")
    void testAdd_positiveNumbers() {
        assertEquals(15, calculator.add(10, 5));
    }

    @Test
    @DisplayName("Penjumlahan dengan bilangan negatif")
    void testAdd_withNegativeNumber() {
        assertEquals(5, calculator.add(10, -5));
    }

    @Test
    @DisplayName("Penjumlahan dua bilangan nol")
    void testAdd_zero() {
        assertEquals(0, calculator.add(0, 0));
    }

    @ParameterizedTest
    @CsvSource({"10, 5, 15", "0, 0, 0", "-5, 5, 0", "100, 200, 300"})
    @DisplayName("Penjumlahan parameterized")
    void testAdd_parameterized(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @Test
    @DisplayName("Pengurangan dua bilangan")
    void testSubtract() {
        assertEquals(5, calculator.subtract(10, 5));
    }

    @Test
    @DisplayName("Pengurangan menghasilkan bilangan negatif")
    void testSubtract_negativeResult() {
        assertEquals(-5, calculator.subtract(5, 10));
    }

    @Test
    @DisplayName("Perkalian dua bilangan")
    void testMultiply() {
        assertEquals(50, calculator.multiply(10, 5));
    }

    @Test
    @DisplayName("Perkalian dengan nol")
    void testMultiply_withZero() {
        assertEquals(0, calculator.multiply(10, 0));
    }

    @Test
    @DisplayName("Pembagian dua bilangan")
    void testDivide() {
        assertEquals(2.0, calculator.divide(10, 5));
    }

    @Test
    @DisplayName("Pembagian dengan nol harus throw exception")
    void testDivide_byZero_throwsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> calculator.divide(10, 0)
        );
        assertEquals("Pembagi tidak boleh nol", exception.getMessage());
    }

    @Test
    @DisplayName("Pembagian menghasilkan desimal")
    void testDivide_returnsDecimal() {
        assertEquals(3.5, calculator.divide(7, 2));
    }
}

package com.skillbox.fibonacci;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class FibonacciCalculatorTest {

    private final FibonacciCalculator calculator = new FibonacciCalculator();

    @ParameterizedTest
    @CsvSource({
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "7, 13",
            "8, 21",
            "9, 34",
            "10, 55"
    })
    @DisplayName("Корректный расчёт чисел Фибоначчи")
    void testFibonacciCorrectValues(int index, int expected) {
        assertEquals(expected, calculator.getFibonacciNumber(index));
    }

    @Test
    @DisplayName("Исключение при индексе меньше 1")
    void testFibonacciWithInvalidIndex() {
        assertThrows(IllegalArgumentException.class, () -> calculator.getFibonacciNumber(0));
        assertThrows(IllegalArgumentException.class, () -> calculator.getFibonacciNumber(-3));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 1"
    })
    @DisplayName("Первые два числа Фибоначчи всегда равны 1")
    void testFibonacciFirstTwoNumbers(int index, int expected) {
        assertEquals(expected, calculator.getFibonacciNumber(index));
    }
}
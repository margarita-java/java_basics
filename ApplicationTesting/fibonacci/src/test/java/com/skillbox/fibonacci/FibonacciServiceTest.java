package com.skillbox.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FibonacciServiceTest {

    private FibonacciRepository repository;
    private FibonacciCalculator calculator;
    private FibonacciService service;

    @BeforeEach
    void setUp() {
        repository = mock(FibonacciRepository.class);
        calculator = mock(FibonacciCalculator.class);
        service = new FibonacciService(repository, calculator);
    }

    @Test
    void shouldReturnNumberFromDatabaseIfExists() {
        int index = 5;
        FibonacciNumber storedNumber = new FibonacciNumber(index, 5);

        when(repository.findByIndex(index)).thenReturn(Optional.of(storedNumber));

        FibonacciNumber result = service.fibonacciNumber(index);

        assertEquals(5, result.getValue());
        verify(repository, times(1)).findByIndex(index);
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(calculator); // Убедимся, что калькулятор не вызывался
    }

    @Test
    void shouldCalculateAndSaveNumberIfNotInDatabase() {
        int index = 6;
        int calculatedValue = 8;

        when(repository.findByIndex(index)).thenReturn(Optional.empty());
        when(calculator.getFibonacciNumber(index)).thenReturn(calculatedValue);

        FibonacciNumber result = service.fibonacciNumber(index);

        assertEquals(index, result.getIndex());
        assertEquals(calculatedValue, result.getValue());

        // Проверка, что метод сохранения был вызван с правильным объектом
        ArgumentCaptor<FibonacciNumber> captor = ArgumentCaptor.forClass(FibonacciNumber.class);
        verify(repository).save(captor.capture());

        FibonacciNumber saved = captor.getValue();
        assertEquals(index, saved.getIndex());
        assertEquals(calculatedValue, saved.getValue());

        verify(repository).findByIndex(index);
        verify(calculator).getFibonacciNumber(index);
    }

    @Test
    void shouldThrowExceptionForInvalidIndex() {
        int invalidIndex = -1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            service.fibonacciNumber(invalidIndex);
        });

        assertEquals("Index should be greater or equal to 1", exception.getMessage());
        verifyNoInteractions(repository, calculator);
    }
}
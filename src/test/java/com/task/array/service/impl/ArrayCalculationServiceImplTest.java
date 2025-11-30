package com.task.array.service.impl;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;
import com.task.array.service.ArrayCalculationService;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCalculationServiceImplTest {

    private final ArrayCalculationService calculationService = new ArrayCalculationServiceImpl();

    @Test
    void findMin_PositiveNumbers_CorrectValue() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new int[]{10, 2, 5});

        OptionalInt actualMin = calculationService.findMin(customArray);

        assertTrue(actualMin.isPresent(), "Result should be present");

        assertEquals(2, actualMin.getAsInt(), "Minimum should be 2");
    }

    @Test
    void findMax_NegativeNumbers_CorrectValue() throws CustomArrayException {

        CustomArray customArray = new CustomArray(new int[]{-5, -1, -10});

        OptionalInt actualMax = calculationService.findMax(customArray);

        assertTrue(actualMax.isPresent());

        assertEquals(-1, actualMax.getAsInt());
    }

    @Test
    void calculateSum_MixedNumbers_CorrectSum() throws CustomArrayException {

        CustomArray customArray = new CustomArray(new int[]{1, -1, 5});

        int actualSum = calculationService.calculateSum(customArray);

        assertEquals(5, actualSum);
    }

    @Test
    void findMin_EmptyArray_ThrowException() {

        CustomArray emptyArray = new CustomArray(new int[]{});

        assertThrows(CustomArrayException.class, () -> calculationService.findMin(emptyArray));
    }
}
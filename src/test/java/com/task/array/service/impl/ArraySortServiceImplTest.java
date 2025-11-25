package com.task.array.service.impl;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;
import com.task.array.service.ArraySortService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraySortServiceImplTest {

    private final ArraySortService sortService = new ArraySortServiceImpl();

    @Test
    void bubbleSort_UnsortedArray_SortedArray() throws CustomArrayException {

        CustomArray customArray = new CustomArray(new int[]{5, 1, 4});

        CustomArray expectedArray = new CustomArray(new int[]{1, 4, 5});

        sortService.bubbleSort(customArray);

        assertEquals(expectedArray, customArray);
    }

    @Test
    void selectionSort_UnsortedArray_SortedArray() throws CustomArrayException {
        CustomArray customArray = new CustomArray(new int[]{10, 2, 8});
        CustomArray expectedArray = new CustomArray(new int[]{2, 8, 10});

        sortService.selectionSort(customArray);

        assertEquals(expectedArray, customArray);
    }

    @Test
    void bubbleSort_NullArray_ThrowException() {
        assertThrows(CustomArrayException.class, () -> sortService.bubbleSort(null));
    }
}
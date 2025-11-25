package com.task.array.service.impl;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;
import com.task.array.service.ArraySortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortServiceImpl implements ArraySortService {

    private static final Logger logger = LogManager.getLogger(ArraySortServiceImpl.class);

    @Override
    public void bubbleSort(CustomArray customArray) throws CustomArrayException {
        checkArray(customArray);
        int[] array = customArray.getArray();
        logger.info("Starting Bubble Sort");

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        logger.info("Bubble Sort finished");
    }

    @Override
    public void selectionSort(CustomArray customArray) throws CustomArrayException {
        checkArray(customArray);
        int[] array = customArray.getArray();
        logger.info("Starting Selection Sort");

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        logger.info("Selection Sort finished");
    }

    private void checkArray(CustomArray customArray) throws CustomArrayException {
        if (customArray == null) {
            logger.error("CustomArray is null");
            throw new CustomArrayException("CustomArray cannot be null");
        }
        int[] array = customArray.getArray();
        if (array == null || array.length == 0) {
            logger.error("Array is empty or null");
            throw new CustomArrayException("Array cannot be empty for sorting");
        }
    }
}
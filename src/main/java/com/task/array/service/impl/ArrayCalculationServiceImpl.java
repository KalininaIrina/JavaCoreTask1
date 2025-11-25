package com.task.array.service.impl;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;
import com.task.array.service.ArrayCalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {

    private static final Logger logger = LogManager.getLogger(ArrayCalculationServiceImpl.class);

    @Override
    public int findMin(CustomArray customArray) throws CustomArrayException {

        checkArray(customArray);

        int[] array = customArray.getArray();;

        int min = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
        }

        logger.info("Min value found: {}", min);
        return min;
    }

    @Override
    public int findMax(CustomArray customArray) throws CustomArrayException {

        checkArray(customArray);

        int[] array = customArray.getArray();

        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }

        logger.info("Max value found: {}", max);
        return max;
    }

    @Override
    public int calculateSum(CustomArray customArray) throws CustomArrayException {

        checkArray(customArray);
        int[] array = customArray.getArray();

        int sum = 0;
        for(int element : array){
            sum += element;
        }

        logger.info("Sum calculated: {}", sum);
        return sum;
    }

    private void checkArray(CustomArray customArray) throws CustomArrayException{

        if (customArray == null){
            logger.error("CustomArray is null");
            throw new CustomArrayException("CustomArray cannot be null");
        }

        int[] array = customArray.getArray();

        if (array == null || array.length == 0){
           logger.error("Array inside CustomArray is empty or null");
           throw new CustomArrayException("Array is empty");
        }

    }

}

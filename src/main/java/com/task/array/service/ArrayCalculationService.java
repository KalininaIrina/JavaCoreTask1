package com.task.array.service;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;

public interface ArrayCalculationService {

    int findMin(CustomArray customArray) throws CustomArrayException;
    int findMax(CustomArray customArray) throws CustomArrayException;
    int calculateSum(CustomArray customArray) throws CustomArrayException;

}

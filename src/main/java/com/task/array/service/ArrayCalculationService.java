package com.task.array.service;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;

import java.util.OptionalInt;

public interface ArrayCalculationService {

    OptionalInt findMin(CustomArray customArray) throws CustomArrayException;
    OptionalInt findMax(CustomArray customArray) throws CustomArrayException;
    int calculateSum(CustomArray customArray) throws CustomArrayException;

}

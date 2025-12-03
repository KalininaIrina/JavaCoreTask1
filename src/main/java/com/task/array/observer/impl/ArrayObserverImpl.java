package com.task.array.observer.impl;

import com.task.array.exception.CustomArrayException;
import com.task.array.observer.ArrayObserver;
import com.task.array.entity.ArrayStatistics;
import com.task.array.entity.CustomArray;
import com.task.array.service.ArrayCalculationService;
import com.task.array.service.impl.ArrayCalculationServiceImpl;
import com.task.array.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalInt;

public class ArrayObserverImpl implements ArrayObserver {

    private static final Logger logger = LogManager.getLogger();

    @Override
    public void changePerformed(CustomArray customArray) {

        int id = customArray.getId();

        logger.info("Observer detected change in array ID: {}", id);

        ArrayCalculationService service = new ArrayCalculationServiceImpl();

        try {

            OptionalInt minOpt = service.findMin(customArray);
            OptionalInt maxOpt = service.findMax(customArray);
            int sum = service.calculateSum(customArray);

            int min = minOpt.orElse(0);
            int max = maxOpt.orElse(0);

            ArrayStatistics newStats = new ArrayStatistics(min, max, sum);

            ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
            warehouse.put(id, newStats);

            logger.info("Warehouse updated for array ID: {}", id);

        } catch (CustomArrayException e) {
            logger.error("Failed to update statistics for array ID: {}", id, e);
        }
    }
}

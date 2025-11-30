package com.task.array.main;

import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;
import com.task.array.factory.ArrayFactory;
import com.task.array.factory.ArrayFactoryImpl;
import com.task.array.parser.ArrayParser;
import com.task.array.parser.ArrayParserImpl;
import com.task.array.reader.ArrayDataReader;
import com.task.array.service.ArrayCalculationService;
import com.task.array.service.ArraySortService;
import com.task.array.service.impl.ArrayCalculationServiceImpl;
import com.task.array.service.impl.ArraySortServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.OptionalInt;

public class Main {


    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ArrayDataReader reader = new ArrayDataReader();
        ArrayParser parser = new ArrayParserImpl();
        ArrayFactory factory = new ArrayFactoryImpl();
        ArrayCalculationService calculationService = new ArrayCalculationServiceImpl();
        ArraySortService sortService = new ArraySortServiceImpl();


        String filePath = "data/arrays.txt";

        try {

            List<String> lines = reader.readLines(filePath);
            logger.info("File read successfully. Lines found: {}", lines.size());

            for (String line : lines) {

                try {
                    logger.info("Processing line: {}", line);


                    int[] numbers = parser.parse(line);

                    CustomArray customArray = factory.create(numbers);


                    OptionalInt min = calculationService.findMin(customArray);
                    if (min.isPresent()) {
                        logger.info("  -> Min value: {}", min.getAsInt());
                    } else {
                        logger.warn("  -> Array is empty, no min value");
                    }


                    int sum = calculationService.calculateSum(customArray);
                    logger.info("  -> Sum: {}", sum);

                    sortService.bubbleSort(customArray);
                    logger.info("  -> Sorted array: {}", customArray); // сработает наш toString()

                } catch (CustomArrayException e) {

                    logger.error("Skipping invalid line: '{}'. Reason: {}", line, e.getMessage());
                }
            }

        } catch (CustomArrayException e) {

            logger.fatal("Critical error: File cannot be read. Application stopped.", e);
        }
    }
}
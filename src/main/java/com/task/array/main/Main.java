package com.task.array.main;

import com.task.array.comparator.SumComparator;
import com.task.array.entity.ArrayStatistics;
import com.task.array.entity.CustomArray;
import com.task.array.exception.CustomArrayException;
import com.task.array.factory.ArrayFactory;
import com.task.array.factory.ArrayFactoryImpl;
import com.task.array.observer.ArrayObserver;
import com.task.array.observer.impl.ArrayObserverImpl;
import com.task.array.parser.ArrayParser;
import com.task.array.parser.ArrayParserImpl;
import com.task.array.reader.ArrayDataReader;
import com.task.array.repository.ArrayRepository;
import com.task.array.specification.Specification;
import com.task.array.specification.SumGreaterThanSpecification;
import com.task.array.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        ArrayDataReader reader = new ArrayDataReader();
        ArrayParser parser = new ArrayParserImpl();
        ArrayFactory factory = new ArrayFactoryImpl();

        ArrayRepository repository = ArrayRepository.getInstance();
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

        String filePath = "data/arrays.txt";

        try {

            List<String> lines = reader.readLines(filePath);
            logger.info("START: Loading arrays from file...");

            for (String line : lines) {
                try {

                    int[] numbers = parser.parse(line);
                    CustomArray customArray = factory.create(numbers);

                    ArrayObserver observer = new ArrayObserverImpl();
                    customArray.attach(observer);

                    repository.add(customArray);

                    customArray.notifyObservers();

                } catch (CustomArrayException e) {

                    logger.error("Skipping line: {}", line);
                }
            }
            logger.info("LOADING COMPLETE. Repository size: {}", repository.getAll().size());


            if (!repository.getAll().isEmpty()) {

                CustomArray firstArray = repository.getAll().get(0);
                int id = firstArray.getId();

                logger.info("--- DEMO: OBSERVER PATTERN ---");
                logger.info("Changing element in array ID: {}", id);

                try {
                    firstArray.setElement(0, 999);
                } catch (CustomArrayException e) {
                    logger.error("Error changing element", e);
                }


                ArrayStatistics stats = warehouse.get(id);
                logger.info("Stats on Warehouse after change: {}", stats);
            }


            logger.info("--- DEMO: SPECIFICATION (FIND) ---");

            Specification sumSpec = new SumGreaterThanSpecification(100);
            List<CustomArray> bigArrays = repository.query(sumSpec);
            logger.info("Found {} arrays with sum > 100", bigArrays.size());
            for (CustomArray arr : bigArrays) {
                logger.info(" -> Found: {}", arr);
            }

            logger.info("--- DEMO: COMPARATOR (SORT) ---");

            List<CustomArray> sortedBySum = repository.sort(new SumComparator());

            logger.info("Arrays sorted by Sum:");
            for (CustomArray arr : sortedBySum) {

                ArrayStatistics stats = warehouse.get(arr.getId());
                int s = (stats != null) ? stats.getSum() : 0;
                logger.info(" -> ID: {}, Sum: {}", arr.getId(), s);
            }

        } catch (CustomArrayException e) {

            logger.fatal("Critical error: " + e.getMessage(), e);
        }
    }
}
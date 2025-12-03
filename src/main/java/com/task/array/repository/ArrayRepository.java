package com.task.array.repository;

import com.task.array.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArrayRepository {

    private static final Logger logger = LogManager.getLogger();

    private static ArrayRepository instance;

    private final List<CustomArray> arrays;

    private ArrayRepository(){
        this.arrays = new ArrayList<>();
    }

    private static ArrayRepository getInstance(){
        if(instance == null){
            instance = new ArrayRepository();
            logger.info("ArrayRepository singleton created");
        }

        return instance;
    }

    public void add(CustomArray customArray){
        arrays.add(customArray);
        logger.info("Added array with ID {} to repository", customArray.getId());
    }

    public void remove(CustomArray customArray){
        arrays.remove(customArray);
        logger.info("Removed array with ID {} from repository", customArray.getId());
    }

    public Optional<CustomArray> getById(int id) {
        for (CustomArray arr : arrays) {
            if (arr.getId() == id) {
                return Optional.of(arr);
            }
        }
        logger.warn("Array with ID {} not found", id);
        return Optional.empty();
    }

    public List<CustomArray> getAll() {
        return new ArrayList<>(arrays);
    }
}

package com.task.array.warehouse;

import com.task.array.entity.ArrayStatistics;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouse {
    private static final Logger logger = LogManager.getLogger();

    private static ArrayWarehouse instance;

    private final Map<Integer, ArrayStatistics> map;

    private ArrayWarehouse(){
        this.map = new HashMap<>();
    }

    public static ArrayWarehouse getInstance() {
        if (instance == null) {

            instance = new ArrayWarehouse();
            logger.info("ArrayWarehowse singleton created");
        }
        return instance;
    }

    public void put(Integer arrayId, ArrayStatistics statistics){

        map.put(arrayId, statistics);
        logger.info("Statistics put for array ID {}: {}", arrayId, statistics);

    }

    public  ArrayStatistics get(Integer arrayId){
        return  map.get(arrayId);
    }

    public void remove(Integer arrayId){
        map.remove(arrayId);
        logger.debug("Statistics removed for array ID {}", arrayId);
    }

    public void update(Integer arrayId, ArrayStatistics statistics){
        this.put(arrayId, statistics);
    }

}

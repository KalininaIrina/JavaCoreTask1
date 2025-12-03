package com.task.array.specification;

import com.task.array.entity.ArrayStatistics;
import com.task.array.entity.CustomArray;
import com.task.array.warehouse.ArrayWarehouse;

public class MaxElementSpecification implements Specification{

    private final int maxLimit;

    public MaxElementSpecification(int maxLimit){
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean specify(CustomArray customArray) {

        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        ArrayStatistics stats = warehouse.get(customArray.getId());

        if(stats == null){
            return false;
        }

        return stats.getMax() == maxLimit;
    }
}

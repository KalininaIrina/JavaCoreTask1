package com.task.array.specification;

import com.task.array.entity.ArrayStatistics;
import com.task.array.entity.CustomArray;
import com.task.array.warehouse.ArrayWarehouse;

public class SumGreaterThanSpecification implements Specification {

    private final int minSum;

    public SumGreaterThanSpecification(int minSum){
        this.minSum = minSum;
    }

    @Override
    public boolean specify(CustomArray customArray){
        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

        ArrayStatistics stats = warehouse.get(customArray.getId());

        if(stats == null){
            return false;
        }

        return stats.getSum()>minSum;
    }

}

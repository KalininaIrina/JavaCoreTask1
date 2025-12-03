package com.task.array.comparator;

import com.task.array.entity.ArrayStatistics;
import com.task.array.entity.CustomArray;
import com.task.array.warehouse.ArrayWarehouse;

import java.util.Comparator;

public class SumComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray o1, CustomArray o2){

        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();

        ArrayStatistics stats1 = warehouse.get(o1.getId());
        ArrayStatistics stats2 = warehouse.get(o2.getId());

        int sum1 = (stats1 != null) ? stats1.getSum() : 0;
        int sum2 = (stats2 != null) ? stats2.getSum() : 0;

        return Integer.compare(sum1, sum2);
    }

}

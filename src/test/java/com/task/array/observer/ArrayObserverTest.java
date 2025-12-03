package com.task.array.observer;

import com.task.array.observer.impl.ArrayObserverImpl;
import org.junit.jupiter.api.Test;

import com.task.array.entity.ArrayStatistics;
import com.task.array.entity.CustomArray;
import com.task.array.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ArrayObserverTest {
    @Test
    void changePerformed_ElementChanged_WarehouseUpdated() throws Exception {
        CustomArray customArray = new CustomArray(new int[]{1, 1, 1});
        int id = customArray.getId();

        ArrayObserver observer = new ArrayObserverImpl();
        customArray.attach(observer);

        customArray.setElement(0, 10);

        ArrayWarehouse warehouse = ArrayWarehouse.getInstance();
        ArrayStatistics stats = warehouse.get(id);

        assertNotNull(stats, "Statistics should appear in Warehouse");
        assertEquals(12, stats.getSum(), "Sum should be updated automatically to 12");
        assertEquals(1, stats.getMin(), "Min should be 1");
        assertEquals(10, stats.getMax(), "Max should be 10");
    }
}

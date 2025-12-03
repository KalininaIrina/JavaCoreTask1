package com.task.array.comparator;

import com.task.array.entity.CustomArray;

import java.util.Comparator;

public class IdComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray o1, CustomArray o2){
        return Integer.compare(o1.getId(), o2.getId());
    }
}

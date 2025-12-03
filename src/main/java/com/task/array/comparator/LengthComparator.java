package com.task.array.comparator;

import com.task.array.entity.CustomArray;

import java.util.Comparator;

public class LengthComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray o1, CustomArray o2){
        return Integer.compare(o1.getArray().length, o2.getArray().length);
    }

}

package com.task.array.factory;

import com.task.array.entity.CustomArray;

public interface ArrayFactory {
    CustomArray create(int[] elements);
}

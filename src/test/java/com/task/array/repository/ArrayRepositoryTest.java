package com.task.array.repository;

import com.task.array.comparator.IdComparator;
import com.task.array.entity.CustomArray;
import com.task.array.specification.IdSpecification;
import com.task.array.specification.Specification;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ArrayRepositoryTest {

    @Test
    void query_IdSpecification_ReturnsCorrectArray() {

        ArrayRepository repository = ArrayRepository.getInstance();

        CustomArray arr1 = new CustomArray(new int[]{1});
        CustomArray arr2 = new CustomArray(new int[]{2});

        repository.add(arr1);
        repository.add(arr2);


        Specification spec = new IdSpecification(arr1.getId());
        List<CustomArray> result = repository.query(spec);


        assertEquals(1, result.size());
        assertEquals(arr1, result.get(0));

        repository.remove(arr1);
        repository.remove(arr2);
    }

    @Test
    void sort_IdComparator_ReturnsSortedList() {
        ArrayRepository repository = ArrayRepository.getInstance();

        CustomArray arr1 = new CustomArray(new int[]{1});
        CustomArray arr2 = new CustomArray(new int[]{2});

        repository.add(arr2);
        repository.add(arr1);

        List<CustomArray> sorted = repository.sort(new IdComparator());

        assertEquals(arr1, sorted.get(0));
        assertEquals(arr2, sorted.get(1));

        repository.remove(arr1);
        repository.remove(arr2);
    }

}

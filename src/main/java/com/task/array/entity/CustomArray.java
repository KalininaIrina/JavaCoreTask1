package com.task.array.entity;
import com.task.array.util.IdGenerator;

import java.util.Arrays;
import java.util.StringJoiner;
import com.task.array.exception.CustomArrayException;
import com.task.array.observer.ArrayObservable;
import com.task.array.observer.ArrayObserver;
import com.task.array.util.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class CustomArray implements ArrayObservable {

    private static final Logger logger = LogManager.getLogger();

    private int id;

    private int[] array;

    private final List<ArrayObserver> observers = new ArrayList<>();

    public CustomArray(int[] array){
        this.id = IdGenerator.generateId();
        this.array = array.clone();
    }

    @Override
    public void attach(ArrayObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detach(ArrayObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (ArrayObserver observer : observers) {
            observer.changePerformed(this);
        }
    }


    public void setElement(int index, int value) throws CustomArrayException {
        if (index < 0 || index >= array.length) {
            throw new CustomArrayException("Index out of bounds");
        }
        array[index] = value;
        logger.info("Element at index {} changed to {}. Notifying observers...", index, value);

        notifyObservers();
    }


    public int getId() {
        return id;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomArray that = (CustomArray) o;
        return id == that.id && Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Arrays.hashCode(array);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CustomArray{");
        sb.append("id=").append(id).append(", array=["); // Добавили вывод ID
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

}

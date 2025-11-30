package com.task.array.entity;
import java.util.Arrays;
import java.util.StringJoiner;

public class CustomArray {

    private int[] array;

    public CustomArray(int[] array){
        this.array = array.clone();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array.clone();
    }

    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }

        if(o == null || getClass() != o.getClass()){
            return false;
        }

        CustomArray that = (CustomArray) o;

       return  Arrays.equals(array, that.array);

    }

    public int hasnCode(){
        return Arrays.hashCode(array);
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder("CustomArray{array=[");
        for (int i = 0; i < array.length; i++){
            sb.append(array[i]);
            if(i < array.length - 1){
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

}

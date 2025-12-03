package com.task.array.specification;

import com.task.array.entity.CustomArray;

public class IdSpecification implements Specification{
    private final int wantedId;

    public IdSpecification(int wantedId){
        this.wantedId = wantedId;
    }

    @Override
    public boolean specify(CustomArray customArray){
        return customArray.getId() == wantedId;
    }

}

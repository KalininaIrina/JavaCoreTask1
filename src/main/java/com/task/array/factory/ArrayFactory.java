package com.task.array.factory;

import com.task.array.entity.CustomArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactory {

    public static final Logger logger = LogManager.getLogger(ArrayFactory.class);

    public CustomArray create(int[] elements){
      logger.info("Creating CustomArray with elements: {}", elements);
      return new CustomArray(elements);
    }

}

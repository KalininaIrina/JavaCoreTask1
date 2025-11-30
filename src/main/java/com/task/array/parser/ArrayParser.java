package com.task.array.parser;

import com.task.array.exception.CustomArrayException;

public interface ArrayParser {
    int[] parse(String line) throws CustomArrayException;
}

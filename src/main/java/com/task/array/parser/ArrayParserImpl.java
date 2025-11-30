package com.task.array.parser;

import com.task.array.exception.CustomArrayException;
import com.task.array.validator.InputDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParserImpl implements ArrayParser {

    private static final Logger logger = LogManager.getLogger();

    private static final String DELIMITER_REGEX = "[,;\\s-]+";

    @Override
    public int[] parse(String line) throws CustomArrayException {

        if(!InputDataValidator.isValidLine(line)){
            logger.error("Invalid line format: {}", line);
            throw new CustomArrayException("Line contains invalid characters: " + line);
        }

        String trimmedLine = line.trim();

        String[] parts = trimmedLine.split(DELIMITER_REGEX);
        int[] numbers = new int[parts.length];

        try{
            for(int i = 0; i < parts.length; i++){
                numbers[i] = Integer.parseInt(parts[i]);
            }
        } catch (NumberFormatException e) {
            logger.error("Error parsing number in line: {}", line, e);
            throw new CustomArrayException("Error parsing number", e);
        }

        logger.info("Successfully parsed line: '{}' to array of size {}", line, numbers.length);
        return numbers;
    }
}

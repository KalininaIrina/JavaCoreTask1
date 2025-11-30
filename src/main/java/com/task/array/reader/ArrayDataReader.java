package com.task.array.reader;

import com.task.array.exception.CustomArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayDataReader {
    private static final Logger logger = LogManager.getLogger();

    public List<String> readLines(String filePath) throws CustomArrayException{
        if(filePath == null){
            logger.error("File path argument is null");
            throw new CustomArrayException("File path can't be null");
        }

        Path path = Paths.get(filePath);

        if(!Files.exists(path)){
            logger.error("File not found at path: {}", filePath);
            throw new CustomArrayException("File not found: ");
        }

        try(Stream<String> lineStream =  Files.lines(path)){
            logger.info("Reading file from path: {}", filePath);
            return lineStream.collect(Collectors.toList());
        } catch (IOException e){
            logger.error("Error reading file: {}", filePath, e);
            throw new CustomArrayException("Error reading file", e);
        }

    }

}

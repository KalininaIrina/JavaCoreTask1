package com.task.array.parser;

import com.task.array.exception.CustomArrayException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayParserImplTest {

    private final ArrayParser parser = new ArrayParserImpl();

    @Test
    void parse_CorrectString_ReturnsArray() throws CustomArrayException {
        String line = "1, 2 - 3; 4   5";
        int[] expected = {1, 2, 3, 4, 5};

        int[] actual = parser.parse(line);

        assertArrayEquals(expected, actual);
    }

    @Test
    void parse_InvalidString_ThrowsException() {
        String line = "1z 2";
        assertThrows(CustomArrayException.class, () -> parser.parse(line));
    }
}
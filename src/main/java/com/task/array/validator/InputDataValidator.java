package com.task.array.validator;

import java.util.regex.Pattern;

public class InputDataValidator {
    private static final String NUMBER_REGEX = "^[\\d\\s,;-]+$";

    private static final Pattern pattern = Pattern.compile(NUMBER_REGEX);
   public static boolean isValidLine(String line) {
       if (line == null || line.trim().isEmpty()) {
           return false;
       }
       return pattern.matcher(line).matches();
   }
}

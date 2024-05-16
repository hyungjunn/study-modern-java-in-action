package com.hyungjunn.modern_java_in_action._07_parallel;

import java.util.stream.Stream;

public class WordCount {
    public static int countWordIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    counter++;
                    lastSpace = false;
                }
            }
        }
        return counter;
    }
}


package com.hyungjunn.modern_java_in_action._05_store2;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamBuilder {
    public static long countUniqueWords() {
        long uniqueWords = 0;
        try(Stream<String> lines = Files.lines(Paths.get("src/test/java/com/hyungjunn/modern_java_in_action/_03_file/data.txt"), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        } catch (IOException e) {
            e.getMessage();
        }
        return uniqueWords;
    }
}

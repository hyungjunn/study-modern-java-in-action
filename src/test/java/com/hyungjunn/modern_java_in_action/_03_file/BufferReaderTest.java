package com.hyungjunn.modern_java_in_action._03_file;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferReaderTest {
    String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("src/test/java/com/hyungjunn/modern_java_in_action/_03_file/data.txt"))) {
            return p.process(br);
        }
    }

    @Test
    void processFile() throws IOException {
        String oneLine = processFile((BufferedReader br) -> br.readLine());

        System.out.println(oneLine);
    }

    @Test
    void processFile2() throws IOException {
        String twoLines = processFile((BufferedReader br) -> br.readLine() + " " + br.readLine());

        System.out.println(twoLines);
    }

    @Test
    void processFile3() throws IOException {
        String oneLine = processFile(new BufferedReaderProcessor() {
            @Override
            public String process(BufferedReader br) throws IOException {
                return br.readLine();
            }
        });

        System.out.println(oneLine);
    }
}

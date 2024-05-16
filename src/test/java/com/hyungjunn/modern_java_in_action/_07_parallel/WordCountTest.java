package com.hyungjunn.modern_java_in_action._07_parallel;

import org.junit.jupiter.api.Test;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCountTest {
     static final String SENTENCE = """
            Hello Java 
            This is a test
            for count word iteratively
            """;

    @Test
    void testCountWordIteratively() {
        int count = WordCount.countWordIteratively(SENTENCE);

        assertThat(count).isEqualTo(10);
    }

    @Test
    void testWordSpliterator() {
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        int count = WordCounter.countWords(stream);

        assertThat(count).isEqualTo(10);
    }
}

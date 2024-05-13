package com.hyungjunn.modern_java_in_action._07_parallel;

import org.junit.jupiter.api.Test;

import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCountTest {
    private static final String SENTENCE = """
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
    void testCountWords() {
        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);

        int count = WordCount.countWords(characterStream.parallel());

        assertThat(count).isEqualTo(43); // 우리가 기대했던 값은 10인데 엉뚱한 값이 나온다.
    }

    @Test
    void testWordSpliterator() {
        Spliterator<Character> spliterator = new WordCounterSpliterator(SENTENCE);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        int count = WordCount.countWords(stream);

        assertThat(count).isEqualTo(10);
    }
}

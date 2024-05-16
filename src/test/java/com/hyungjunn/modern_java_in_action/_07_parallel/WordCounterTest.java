package com.hyungjunn.modern_java_in_action._07_parallel;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.hyungjunn.modern_java_in_action._07_parallel.WordCountTest.SENTENCE;
import static org.assertj.core.api.Assertions.assertThat;

public class WordCounterTest {
    @Test
    void testAccumulate() {
        WordCounter wordCounter = new WordCounter(0, true);

        WordCounter seperatedWordCounter = wordCounter.accumulate('a');

        assertThat(seperatedWordCounter).isEqualTo(new WordCounter(1, false));
    }

    @Test
    void testCombine() {
        WordCounter rightCounter = new WordCounter(10, true);
        WordCounter leftCounter = new WordCounter(20, true);

        WordCounter all = rightCounter.combine(leftCounter);

        assertThat(all).isEqualTo(new WordCounter(30, true));
    }

    @Test
    void testCountWords() {
        Stream<Character> characterStream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);

        int count = WordCounter.countWords(characterStream.parallel());

        assertThat(count).isEqualTo(43); // 우리가 기대했던 값은 10인데 엉뚱한 값이 나온다.
    }
}

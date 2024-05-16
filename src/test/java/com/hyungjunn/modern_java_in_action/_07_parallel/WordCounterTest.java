package com.hyungjunn.modern_java_in_action._07_parallel;

import org.junit.jupiter.api.Test;

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
}

package com.hyungjunn.modern_java_in_action._07_parallel;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class WordCounterTest {
    @Test
    void testAccumulate() {
        WordCounter wordCounter = new WordCounter(0, true);

        WordCounter seperatedWordCounter = wordCounter.accumulate('a');

        Assertions.assertThat(seperatedWordCounter).isEqualTo(new WordCounter(1, false));
    }
}

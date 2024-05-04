package com.hyungjunn.modern_java_in_action._03_int_predicate;

import org.junit.jupiter.api.Test;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class IntPredicateTest {
    @Test
    void testPrimitive() {
        IntPredicate evenNumbers = (int i) -> i % 2 == 0;
        boolean tested = evenNumbers.test(1000);
        assertThat(tested).isTrue();
    }

    @Test
    void testReference() {
        Predicate<Integer> oddNumbers = (Integer i) -> i % 2 != 0;
        boolean tested = oddNumbers.test(1000);
        assertThat(tested).isFalse();
    }
}

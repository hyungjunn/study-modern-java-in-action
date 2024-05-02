package com.hyungjunn.modern_java_in_action._03_functional_interface;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionalInterfaceTest {
    @Test
    void testBiFunction() {
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> Integer.max(a, b);
        int result = adder.apply(4, 5);
        assertThat(result).isEqualTo(5);
    }

    @Test
    void testBiFunction2() {
        BiFunction<Integer, Integer, Integer> adder = (a, b) -> Integer.sum(a, b);
        int result = adder.apply(4, 5);
        assertThat(result).isEqualTo(9);
    }

    @Test
    void testSupplier() {
        Supplier<Integer> numberSupplier = () -> 5;
        int result = numberSupplier.get();
        assertThat(result).isEqualTo(5);
    }

    @Test
    void testUnaryOperator() {
        String result = "operation";
        UnaryOperator<String> operator = a -> a;
        String operation = operator.apply(result);
        assertThat(operation).isEqualTo(result);
    }
}

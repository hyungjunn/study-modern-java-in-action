package com.hyungjunn.modern_java_in_action._03_functional_interface;

import com.hyungjunn.modern_java_in_action._02_apples.Apple;
import com.hyungjunn.modern_java_in_action._02_apples.Color;
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
    void testBiFunction3() {
        // 두 사과의 무게를 비교하는 로직
        BiFunction<Apple, Apple, Integer> adder = (apple1, apple2) -> Integer.max(apple1.getWeight(), apple2.getWeight());
        int result = adder.apply(new Apple(300, Color.RED), new Apple(400, Color.RED));
        assertThat(result).isEqualTo(400);
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

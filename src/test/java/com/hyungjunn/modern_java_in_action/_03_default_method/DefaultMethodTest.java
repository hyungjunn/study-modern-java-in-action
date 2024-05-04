package com.hyungjunn.modern_java_in_action._03_default_method;

import com.hyungjunn.modern_java_in_action._02_apples.Apple;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static com.hyungjunn.modern_java_in_action._02_apples.Color.GREEN;
import static com.hyungjunn.modern_java_in_action._02_apples.Color.RED;
import static org.assertj.core.api.Assertions.assertThat;

public class DefaultMethodTest {
    @ParameterizedTest
    @CsvSource(value = {"0:155", "1:120", "2:80"}, delimiter = ':')
    void testReversed(int input, int expected) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED)
        );
        // 위의 사과들의 무게를 내림차순으로 정렬 => 155, 120, 80
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());

        assertThat(inventory.get(input).getWeight()).isEqualTo(expected);
    }
}

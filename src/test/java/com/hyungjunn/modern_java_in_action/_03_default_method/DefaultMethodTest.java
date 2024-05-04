package com.hyungjunn.modern_java_in_action._03_default_method;

import com.hyungjunn.modern_java_in_action._02_apples.Apple;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static com.hyungjunn.modern_java_in_action._02_apples.Color.*;
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

    @ParameterizedTest
    @CsvSource(value = {"0:busan", "1:daegu", "2:jeju"}, delimiter = ':')
    void testThenComparing(int input, String expected) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN, "daegu"),
                new Apple(80, GREEN, "busan"),
                new Apple(80, GREEN, "jeju")
        );
        // 위에 처럼 무게를 내림차순으로 정렬
        // 그 때, 무게가 같다면 국가별로 정렬
        inventory.sort(
                Comparator.comparing(Apple::getWeight)
                        .reversed()
                        .thenComparing(Apple::getCountry)
        );

        // 155 120 80
        // busan daegu jeju
        assertThat(inventory.get(input).getCountry()).isEqualTo(expected);
        System.out.println("inventory = " + inventory);
    }

    @Test
    void testNegate() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED),
                new Apple(120, ORANGE)
        );

        Predicate<Apple> redApple = Apple::isRed;
        Predicate<Apple> notRedApple = redApple.negate();

        long count = inventory.stream()
                .filter(notRedApple)
                .count();

        assertThat(count).isEqualTo(3L);
    }

    @Test
    void testAndOr() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED),
                new Apple(120, ORANGE)
        );

        Predicate<Apple> redApple = Apple::isRed;
        Predicate<Apple> notRedApple = redApple.negate();
        Predicate<Apple> notRedAndHeavyApple = notRedApple.and(apple -> apple.isWeightAbove(150));

        long count = inventory.stream()
                .filter(notRedAndHeavyApple)
                .count();

        assertThat(count).isEqualTo(1L);
    }
}

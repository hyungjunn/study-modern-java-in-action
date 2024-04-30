package com.hyungjunn.modern_java_in_action._02_apples;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.hyungjunn.modern_java_in_action._02_apples.Color.GREEN;
import static com.hyungjunn.modern_java_in_action._02_apples.Color.RED;
import static org.assertj.core.api.Assertions.*;

public class FilteringApplesTest {
    @Test
    void filterGreenApples() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED)
        );

        List<Apple> greenApples = FilteringApples.filterGreenApples(inventory);
        assertThat(greenApples).hasSize(2);
    }
}

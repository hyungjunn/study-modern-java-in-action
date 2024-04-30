package com.hyungjunn.modern_java_in_action._02_apples;

import com.hyungjunn.modern_java_in_action._02_apples.strategy.AppleGreenColorPredicate;
import com.hyungjunn.modern_java_in_action._02_apples.strategy.AppleHeavyWeightPredicate;
import com.hyungjunn.modern_java_in_action._02_apples.strategy.AppleRedColorAndLightPredicate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.hyungjunn.modern_java_in_action._02_apples.Color.GREEN;
import static com.hyungjunn.modern_java_in_action._02_apples.Color.RED;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class FilteringApplesTest {
    private List<Apple> inventory;

    @BeforeEach
    void setUp() {
        inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED)
        );
    }

    @Test
    void filterGreenApples() {
        List<Apple> greenApples = FilteringApples.filterGreenApples(inventory);
        assertThat(greenApples).hasSize(2);
    }

    @Test
    void filterApplesByColor() {
        List<Apple> greenApples = FilteringApples.filterApplesByColor(inventory, GREEN);
        assertThat(greenApples).hasSize(2);

        List<Apple> redApples = FilteringApples.filterApplesByColor(inventory, RED);
        assertThat(redApples).hasSize(1);
    }

    @Test
    void filterApplesByWeight() {
        List<Apple> greenApples = FilteringApples.filterApplesByWeight(inventory, 150);
        assertThat(greenApples).hasSize(1);
    }

    @Test
    void filterApples() {
        List<Apple> greenApples = FilteringApples.filterApples(inventory, GREEN, 0, true);
        assertThat(greenApples).hasSize(2);

        List<Apple> heavyApples = FilteringApples.filterApples(inventory, null, 150, false);
        assertThat(heavyApples).hasSize(1);
    }

    @Test
    void filterApplesByAppleGreenColorPredicate() {
        List<Apple> greenApples = FilteringApples.filterApples(inventory, new AppleGreenColorPredicate());
        assertThat(greenApples).hasSize(2);
    }

    @Test
    void filterApplesByAppleHeavyWeightPredicate() {
        List<Apple> greenApples = FilteringApples.filterApples(inventory, new AppleHeavyWeightPredicate());
        assertThat(greenApples).hasSize(1);
    }

    @Test
    void filterApplesByAppleRedColorAndLightWeightPredicate() {
        List<Apple> redAndLightApples = FilteringApples.filterApples(inventory, new AppleRedColorAndLightPredicate());
        assertThat(redAndLightApples).hasSize(1 );
    }

    @Test
    void filterApplesByAnonymousClass() {
        List<Apple> redApples = FilteringApples.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.isRed();
            }
        });
        assertThat(redApples).hasSize(1);
    }
}

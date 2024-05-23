package com.hyungjunn.modern_java_in_action._09_refactoring;

import com.hyungjunn.modern_java_in_action._02_apples.Apple;
import com.hyungjunn.modern_java_in_action._04_store.Dish;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.hyungjunn.modern_java_in_action._02_apples.Color.GREEN;
import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static java.util.Comparator.comparing;
import static org.assertj.core.api.Assertions.*;

public class MethodReferenceTest {
    @Test
    void testMethodReference() {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN, "daegu"),
                new Apple(90, GREEN, "busan"),
                new Apple(50, GREEN, "jeju")
        );

        inventory.sort(
                comparing(Apple::getWeight)
        );

        System.out.println(inventory);
    }

    @Test
    void testSummingInt() {
        Integer totalCalories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, (c1, c2) -> c1 + c2);

        Integer totalCaloriesBySummingInt = menu.stream()
                .collect(Collectors.summingInt(Dish::getCalories));
        assertThat(totalCalories).isEqualTo(totalCaloriesBySummingInt);
    }

    @Test
    void testStream() {
        // 명령형 버전
        List<String> dishNames = new ArrayList<>();
        for (Dish dish : menu) {
            if (dish.getCalories() > 300) {
                dishNames.add(dish.getName());
            }
        }

        // 스트림 버전
        List<String> list = menu.stream()
                .filter(it -> it.getCalories() > 300)
                .map(Dish::getName)
                .toList();

        assertThat(dishNames.toString()).isEqualTo(list.toString());
    }
}

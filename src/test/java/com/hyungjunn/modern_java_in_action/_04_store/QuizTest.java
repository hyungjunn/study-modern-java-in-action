package com.hyungjunn.modern_java_in_action._04_store;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static org.assertj.core.api.Assertions.assertThat;

public class QuizTest {
    @Test
    void testHighCaloricDishes() {
        List<String> highCaloriesDishes = Order.orderHighCaloriesDishes(menu);

        assertThat(highCaloriesDishes).hasSize(8);
    }
}

package com.hyungjunn.modern_java_in_action._05_store2;

import com.hyungjunn.modern_java_in_action._04_store.Dish;
import com.hyungjunn.modern_java_in_action._04_store.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static com.hyungjunn.modern_java_in_action._04_store.DishTest.specialMenu;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamTest {
    @Test
    void testExternalIteration() {
        List<Dish> vegetarianDishes = Order.orderVegetarianByExternal(menu);

        assertThat(vegetarianDishes).hasSize(4);
    }

    @Test
    void testInternalIteration() {
        List<Dish> vegetarianDishes = Order.orderVegetarianByInternal(menu);

        assertThat(vegetarianDishes).hasSize(4);
    }

    @Test
    void testDistinct() {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4, 1, 1, 1, 1);
        List<Integer> distinctEvenNumbers = numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .toList();

        assertThat(distinctEvenNumbers).hasSize(2);
        assertThat(distinctEvenNumbers.get(0)).isEqualTo(2);;
        assertThat(distinctEvenNumbers.get(1)).isEqualTo(4);;
    }

    @Test
    void testFilter() {
        List<Dish> filteredMenu = Order.filterLessThanCalories(specialMenu);

        assertThat(filteredMenu).hasSize(2);
    }

    @Test
    void testTakeWhile() {
        List<Dish> slicedMenu1 = Order.filterLessThanCaloriesByTakeWhile(specialMenu);

        assertThat(slicedMenu1).hasSize(2);
    }

    @Test
    void testDropWhile() {
        List<Dish> slicedMenu2 = Order.filterLessThanCaloriesByDropWhile(specialMenu);

        assertThat(slicedMenu2).hasSize(3);
    }

    @Test
    void testLimit() {
        List<Dish> dishes = Order.filterLimitThree(specialMenu);

        assertThat(dishes).hasSize(3);
    }

    @Test
    void testSkip() {
        List<Dish> dishes = Order.filterGreaterThan300AndSkipTwo(menu);

        assertThat(dishes).hasSize(6);
    }

    @Test
    void testQuiz_5_1() {
        List<Dish> meatDishes = Order.filterToMeatAndLimitTwo(menu);

        assertThat(meatDishes).hasSize(2);
    }
}

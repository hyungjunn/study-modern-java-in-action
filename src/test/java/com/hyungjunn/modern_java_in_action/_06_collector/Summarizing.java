package com.hyungjunn.modern_java_in_action._06_collector;

import com.hyungjunn.modern_java_in_action._04_store.Dish;

import java.util.Comparator;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static java.util.stream.Collectors.maxBy;

public class Summarizing {
    public static Dish findMostCaloricDishUsingComparator() {
        // 칼로리로 요리를 비교하는 Comparator<Dish> 를 구현
        Comparator<Dish> dishCaloriesComparator = Comparator.comparing(Dish::getCalories);
        // Collectors.maxBy 로 전달
        return menu.stream()
                .collect(maxBy(dishCaloriesComparator))
                .orElseThrow();
    }
}

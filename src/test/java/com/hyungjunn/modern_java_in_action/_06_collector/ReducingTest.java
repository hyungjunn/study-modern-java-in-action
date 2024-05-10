package com.hyungjunn.modern_java_in_action._06_collector;

import com.hyungjunn.modern_java_in_action._04_store.Dish;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static java.util.stream.Collectors.reducing;
import static org.assertj.core.api.Assertions.assertThat;

public class ReducingTest {
    @Test
    void testReducing() {
        //int totalCalories = menu.stream().collect(reducing(0, Dish::getCalories, Integer::sum));
        //int totalCalories = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        int totalCalories = menu.stream().mapToInt(Dish::getCalories).sum();

        assertThat(totalCalories).isEqualTo(4300);
    }

    @Test
    void testReducing2() {
        Dish mostCaloriesDish = menu.stream()
                .collect(reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2))
                .orElseThrow();

        assertThat(mostCaloriesDish.getCalories()).isEqualTo(800);
    }

    @Test
    void testReduce() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6).stream();
        stream.reduce(
                new ArrayList<Integer>(),
                (List<Integer> l, Integer e) -> {
                    l.add(e);
                    return l; },
                (List<Integer> l1, List<Integer> l2) -> {
                    l1.addAll(l2);
                    return l1;
                });
    }
}

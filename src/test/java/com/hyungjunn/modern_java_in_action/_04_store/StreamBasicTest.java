package com.hyungjunn.modern_java_in_action._04_store;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class StreamBasicTest {
    @Test
    void testOrderLowCaloricDishesNamesInJava7() {
        List<String> lowCaloricDishesName = Order.orderLowCaloricDishesNamesInJava7(menu);

        assertThat(lowCaloricDishesName.size()).isEqualTo(2);
        assertThat(lowCaloricDishesName).containsExactly("season fruit", "rice");
    }

    @Test
    void testOrderLowCaloricDishesNamesInJava8() {
        List<String> lowCaloricDishesName = Order.orderLowCaloricDishesNamesInJava8(menu);

        assertThat(lowCaloricDishesName.size()).isEqualTo(2);
        assertThat(lowCaloricDishesName).containsExactly("season fruit", "rice");
    }

    @Test
    void testOrderLowCaloricDishesNamesInParallelStream() {
        List<String> lowCaloricDishesName = Order.OrderLowCaloricDishesNamesInParallelStream(menu);

        assertThat(lowCaloricDishesName.size()).isEqualTo(2);
        assertThat(lowCaloricDishesName).containsExactly("season fruit", "rice");
    }

    @Test
    void testOrderThreeHighCaloricDishesName() {
        List<String> threeHighCaloricDishesName = Order.orderThreeHighCaloricDishesName(menu);

        assertThat(threeHighCaloricDishesName).hasSize(3);
        assertThat(threeHighCaloricDishesName).containsExactly("pork", "beef", "chicken");
    }

    @Test
    void testForEach() {
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream<String> stream = title.stream();
        stream.forEach(System.out::println);
        //stream.forEach(System.out::println); // message: stream has already been operated upon or closed
    }

    @Test
    void testExternalIteration() {
        List<String> names = Order.externalIteration(menu);

        assertThat(names).hasSize(9);
    }

    @Test
    void testInternalIteration() {
        List<String> names = Order.internalIteration(menu);
        assertThat(names).hasSize(9);
    }

    @Test
    void testIntermediateOperation() {
        List<String> names = menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .toList();

        System.out.println("names = " + names);
    }
}

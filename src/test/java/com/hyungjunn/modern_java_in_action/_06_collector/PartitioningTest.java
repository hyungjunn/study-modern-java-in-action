package com.hyungjunn.modern_java_in_action._06_collector;

import com.hyungjunn.modern_java_in_action._04_store.Dish;
import com.hyungjunn.modern_java_in_action._04_store.Type;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class PartitioningTest {
    @ParameterizedTest
    @MethodSource("provideBooleanAndExpectedDishes")
    void testPartitionByVegetarian(Boolean provided, List<Dish> expected) {
        Map<Boolean, List<Dish>> partitionedMenu = Partitioning.partitionByVegetarian();
        System.out.println(partitionedMenu);

        Assertions.assertThat(partitionedMenu).containsEntry(provided, expected);
    }

    private static Stream<Arguments> provideBooleanAndExpectedDishes() {
        return Stream.of(
                Arguments.of(false, List.of(
                        new Dish("pork", false, 800, Type.MEAT),
                        new Dish("beef", false, 700, Type.MEAT),
                        new Dish("chicken", false, 400, Type.MEAT),
                        new Dish("prawns", false, 400, Type.FISH),
                        new Dish("salmon", false, 450, Type.FISH))),
                Arguments.of(true, List.of(
                        new Dish("french fries", true, 530, Type.OTHER),
                        new Dish("rice", true, 350, Type.OTHER),
                        new Dish("season fruit", true, 120, Type.OTHER),
                        new Dish("pizza", true, 550, Type.OTHER)
                ))
        );
    }

    @Test
    void testVegetarianDishesByType() {
        Map<Boolean, Map<Type, List<Dish>>> vegetarianDishes = Partitioning.vegetarianDishesByType();

        System.out.println(vegetarianDishes);
    }

    @Test
    void testMostCaloricPartitionedByVegetarian() {
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian = Partitioning.mostCaloricPartitionedByVegetarian();

        System.out.println(mostCaloricPartitionedByVegetarian);
    }
}

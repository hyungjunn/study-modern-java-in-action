package com.hyungjunn.modern_java_in_action._06_collector;

import com.hyungjunn.modern_java_in_action._04_store.Dish;
import com.hyungjunn.modern_java_in_action._04_store.Type;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static java.util.stream.Collectors.*;

public class Partitioning {
    public static Map<Boolean, List<Dish>> partitionByVegetarian() {
        return menu.stream().collect(partitioningBy(Dish::isVegetarian));
    }

    public static Map<Boolean, Map<Type, List<Dish>>> vegetarianDishesByType() {
        return menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        groupingBy(Dish::getType)));
    }

    public static Map<Boolean, Dish> mostCaloricPartitionedByVegetarian() {
        return menu.stream()
                .collect(partitioningBy(Dish::isVegetarian,
                        collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)),
                                Optional::get)));
    }
}

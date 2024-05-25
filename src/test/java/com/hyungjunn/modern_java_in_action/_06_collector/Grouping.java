package com.hyungjunn.modern_java_in_action._06_collector;

import com.hyungjunn.modern_java_in_action._04_store.Dish;
import com.hyungjunn.modern_java_in_action._04_store.Type;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.dishTags;
import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static com.hyungjunn.modern_java_in_action._06_collector.CaloricLevel.*;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class Grouping {
    public static Map<Type, List<Dish>> groupDishesByType() {
        return menu.stream().collect(groupingBy(Dish::getType));
    }

    public static Map<CaloricLevel, List<Dish>> groupDishesByCaloricLevel() {
        return menu.stream().collect(groupingBy(Dish::getCaloricLevel));
    }

    public static Map<Type, List<Dish>> groupCaloricDishesByType() {
        // 평범하고 단순하게 생각했을 때 코드
        // 키 버킷이 Type 이고, 칼로리가 500 을 초과하는 Dishes
        // return menu.stream()
        //         .filter(dish -> dish.getCalories() > 500)
        //         .collect(groupingBy(Dish::getType));
        return menu.stream()
                .collect(groupingBy(Dish::getType,
                        filtering(dish -> dish.getCalories() > 500, toList())));
        // filtering 메서드는 또 다른 정적 팩터리 메서드. 프레디케이드를 인수로 받음.
    }

    public static Map<Type, List<String>> groupDishNamesByType() {
        return menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));
    }

    public static Map<Type, Set<String>> groupDishTagsByType() {
        return menu.stream()
                .collect(groupingBy(Dish::getType,
                        flatMapping(dish -> dishTags.get(dish.getName()).stream(), toSet())));
    }


    public static Map<Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return menu.stream()
                .collect(groupingBy(Dish::getType,
                        groupingBy(dish -> {
                            if (dish.getCalories() <= 400) {
                                return DIET;
                            } else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            } else
                                return CaloricLevel.FAT;
                        })));
    }

    public static Map<Type, Long> countDishesType() {
        return menu.stream()
                .collect(groupingBy(Dish::getType, counting()));
    }

    public static Map<Type, Optional<Dish>> mostCaloricDishesByType() {
        return menu.stream()
                .collect(groupingBy(Dish::getType,
                        maxBy(comparingInt(Dish::getCalories))));
    }

    public static Map<Type, Dish> mostCaloricDishesByTypeWithoutOptionals() {
        return menu.stream()
                .collect(groupingBy(Dish::getType,
                        collectingAndThen(
                                maxBy(comparingInt(Dish::getCalories)),
                                Optional::get)));
    }

    public static Map<Type, Integer> sumCaloriesByType() {
        return menu.stream()
                .collect(groupingBy(Dish::getType,
                        summingInt(Dish::getCalories)));
    }

    public static Map<Type, Set<CaloricLevel>> caloricLevelsByType() {
        return menu.stream()
                .collect(groupingBy(Dish::getType, mapping(dish -> {
                            if (dish.getCalories() <= 400) {
                                return DIET;
                            } else if (dish.getCalories() <= 700) {
                                return NORMAL;
                            } else {
                                return FAT;
                            }
                        }, toSet()) // toCollection(HashSet::new) 도 가능하다
                ));
    }
}

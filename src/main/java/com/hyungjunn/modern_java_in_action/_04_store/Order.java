package com.hyungjunn.modern_java_in_action._04_store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class Order {
    public static List<String> orderLowCaloricDishesNamesInJava7(List<Dish> menu) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        // 메뉴를 순회하면서
        for (Dish dish : menu) {
            // 칼로리가 400미만이면
            if (dish.getCalories() < 400) {
                // lowCaloricDishes 에 추가한다
                lowCaloricDishes.add(dish);
            }
        }
        // 각각 칼로리를 비교해서 정렬한다
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish dish1, Dish dish2) {
                return Integer.compare(dish1.getCalories(), dish2.getCalories()); //rice350 seasonfruit120
            }
        });

        List<String> lowCaloricDishesName = new ArrayList<>();
        // lowCaloricDishes 를 순회하면서
        for (Dish lowCaloricDish : lowCaloricDishes) {
            // 요리들의 이름을 lowCaloricDishesName 에 추가한다
            lowCaloricDishesName.add(lowCaloricDish.getName());

        }
        return lowCaloricDishesName;
    }

    public static List<String> orderLowCaloricDishesNamesInJava8(List<Dish> menu) {
        return menu.stream()
                .filter(it -> it.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    public static List<String> OrderLowCaloricDishesNamesInParallelStream(List<Dish> menu) {
        return menu.parallelStream()
                .filter(it -> it.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
    }

    public static List<String> orderThreeHighCaloricDishesName(List<Dish> menu) {
        return menu.stream()
                .filter(it -> it.getCalories() > 300)
                .map(Dish::getName)
                .limit(3)
                .collect(toList());
    }

    public static List<String> externalIteration(List<Dish> menu) {
        List<String> names = new ArrayList<>();
        for (Dish dish : menu) {
            names.add(dish.getName());
        }
        //Iterator<Dish> iterator = menu.iterator();
        //while (iterator.hasNext()) {
        //    Dish dish = iterator.next();
        //    names.add(dish.getName());
        //}
        return names;
    }

    public static List<String> internalIteration(List<Dish> menu) {
        return menu.stream()
                .map(Dish::getName) // map 메서드를 getName 메서드로 파라미터화해서 요리명을 추출한다
                .collect(toList()); // 파이프라인을 실행한다. 반복자는 필요 없다.
    }

    public static List<String> orderHighCaloriesDishes(List<Dish> menu) {
        return menu.stream()
                .filter(it -> it.getCalories() > 300)
                .map(Dish::getName)
                .collect(toList());
    }
}

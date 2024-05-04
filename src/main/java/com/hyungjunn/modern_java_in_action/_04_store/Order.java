package com.hyungjunn.modern_java_in_action._04_store;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
}

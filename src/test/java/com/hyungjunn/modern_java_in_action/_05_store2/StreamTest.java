package com.hyungjunn.modern_java_in_action._05_store2;

import com.hyungjunn.modern_java_in_action._04_store.Dish;
import com.hyungjunn.modern_java_in_action._04_store.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static com.hyungjunn.modern_java_in_action._04_store.DishTest.specialMenu;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
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

    @Test
    void testMap1() {
        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");

        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .toList();

        assertThat(wordLengths).hasSize(4);
        assertThat(wordLengths).containsExactly(6, 4, 2, 6);
    }

    @Test
    void testMap2() {
        List<Integer> dishNamesLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .distinct()
                .sorted(comparing(Integer::intValue))
                .toList();

        assertThat(dishNamesLengths).containsExactly(4, 5, 6, 7, 12);
    }

    @Test
    void testMap3() {
        List<String> words = Arrays.asList("Hello", "World");

        words.stream()
                .map(it -> {
                    System.out.println(Arrays.toString(it.split("")));
                    return it.split(""); // 나는 H e l l o W o r l d 를 mapping 하고 싶은데 현실은 [H,e,l,l,o], [W,o,r,l,d]
                })
                .distinct()
                .toList();

        List<String> list = words.stream()
                .flatMap(line -> Arrays.stream(line.split("")))
                .distinct()
                .toList();

        assertThat(list).containsExactly("H", "e", "l", "o", "W", "r", "d");
    }

    @Test
    void testMap4() {
        List<String> words = Arrays.asList("Hello", "World");

        List<String> list = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();

        assertThat(list).containsExactly("H", "e", "l", "o", "W", "r", "d");
    }

    @Test
    void testQuiz_5_2() {
        // 1
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(x -> x * x)
                .toList();

        assertThat(squares).containsExactly(1, 4, 9, 16, 25);

        // 2
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .toList();

        assertThat(pairs).hasSize(6);

        // 3
        List<int[]> pairsMultiplesOfThree = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .toList();

        assertThat(pairsMultiplesOfThree).hasSize(2);
    }

    @Test
    void testAnyMatch() {
        boolean isVegetarianAnyMatch = menu.stream().anyMatch(Dish::isVegetarian);
        assertThat(isVegetarianAnyMatch).isTrue();
    }

    @Test
    void testAllMatch() {
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);

        assertThat(isHealthy).isTrue();
    }

    @Test
    void testNoneMatch() {
        // noneMatch 는 allMatch 와 반대 연산을 수행한다
        boolean isHealthy = menu.stream()
                .noneMatch(dish -> dish.getCalories() >= 1000);

        assertThat(isHealthy).isTrue();
    }
}

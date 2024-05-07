package com.hyungjunn.modern_java_in_action._05_store2;

import com.hyungjunn.modern_java_in_action._04_store.Dish;
import com.hyungjunn.modern_java_in_action._04_store.Order;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static com.hyungjunn.modern_java_in_action._04_store.DishTest.specialMenu;
import static java.util.Comparator.comparing;
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

    @Test
    void testFindAny() {
        Optional<Dish> dish = menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();

        // isVegetarian 인 걸 찾았으면 끝 => 쇼트서킷 평가
        assertThat(dish.get().getCalories()).isEqualTo(530);
    }

    @Test
    void testFindAnyIfPresent() {
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(it -> System.out.println(it.getName())); // french fries
    }

    @Test
    void testFindFirst() {
        // 숫자 리스트에서 3으로 나누어 떨어지는 첫 번째 제곱값을 반환하는 코드를 테스트하라
        // 병렬성을 띄는 경우에는 findFirst 보다는 제약이 적은 findAny 를 쓰게 된다.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer number = numbers.stream()
                .map(x -> x * x)
                .filter(y -> y % 3 == 0)
                .findFirst()
                .orElseThrow();

        assertThat(number).isEqualTo(9);
    }

    @Test
    void testReduce1() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // for-each loop
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        assertThat(sum).isEqualTo(15);

        // reduce
        Integer sumByReduce = numbers.stream()
                .reduce(0, Integer::sum);
        assertThat(sumByReduce).isEqualTo(15);

        // override reduce
        Integer sumByOverrideReduce = numbers.stream()
                .reduce(Integer::sum)
                .orElseThrow();
        assertThat(sumByOverrideReduce).isEqualTo(15);
    }

    @Test
    void testQuiz_5_3() {
        // map 과 reduce 메서드를 이용해서 스트림의 요리 갯수를 계산하시오.
        // 갯수를 구할 때, 아주 유용한 방식
        // 맵-리듀스 패턴: 쉽게 병렬화하게 되어 구글이 이 방식으로 웹 검색에 적용하면서 유명해짐
        int dishesNo = menu.stream()
                .map(it -> 1)
                .reduce(0, Integer::sum);
        assertThat(dishesNo).isEqualTo(9);
    }

    @Test
    void testIntStream() {
        int calories = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();

        assertThat(calories).isEqualTo(4300);
    }

    @Test
    void testIntStreamToStream() {
        IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
        List<Integer> list = stream.toList();
        assertThat(list).hasSize(9);
    }

    @Test
    void testOptionalInt() {
        int maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max()
                .orElse(1); // 최댓값이 없는 상황에 사용할 기본값을 정의할 수 있음

        assertThat(maxCalories).isEqualTo(800);
    }

    @Test
    void testRangeClosed() {
        long count = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0)
                .count();

        // range 는 종료값을 제외
        // rangeClosed 는 종료값을 포함
        assertThat(count).isEqualTo(50L);
    }

    @Test
    void testPythagoreanTriples() {
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a ->
                        IntStream.rangeClosed(a, 100)
                                .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                                .filter(t -> t[2] % 1 == 0))
                        .map(array -> Arrays.stream(array).mapToInt(a -> (int)a).toArray());

        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));
    }

    @Test
    void testMakeStreamValue() {
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        Stream<String> emptyStream = Stream.empty();
        emptyStream.forEach(System.out::println);
    }

    @Test
    void testMakeStreamNullable() {
        Stream<String> homeValueStream = Stream.ofNullable(System.getProperty("home"));

        Stream<String> values = Stream.of("config", "home", "user")
                .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
    }

    @Test
    void testMakeStreamArray() {
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();

        assertThat(sum).isEqualTo(41);
    }

    @Test
    void testMakeStreamByFile() {
        long uniqueWords = StreamBuilder.countUniqueWords();

        assertThat(uniqueWords).isEqualTo(4);
    }

    @Test
    void testFibonacciSequence() {
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
    }

    @Test
    void testIterate() {
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);

        // non-short-circuit
        // IntStream.iterate(0, n -> n + 4)
        //         .filter(n -> n < 100)
        //         .forEach(System.out::println);

        // 위의 three parameter iterate 와 같은 동작을 한다
        IntStream.iterate(0, n -> n + 4)
                .takeWhile(n -> n < 100)
                .forEach(System.out::println);
    }

    @Test
    void testGenerate() {
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }
}

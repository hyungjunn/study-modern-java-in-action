package com.hyungjunn.modern_java_in_action._06_collector;

import com.hyungjunn.modern_java_in_action._04_store.Dish;
import com.hyungjunn.modern_java_in_action._04_store.Type;
import org.junit.jupiter.api.Test;

import java.util.IntSummaryStatistics;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.assertThat;

public class SummarizingTest {
    @Test
    void testCounting() {
        //long count = menu.stream().count();
        long count = menu.stream().collect(counting());
        assertThat(count).isEqualTo(9);
    }

    @Test
    void testMaxBy() {
        Dish dish = Summarizing.findMostCaloricDishUsingComparator();

        assertThat(dish).isEqualTo(new Dish("pork", false, 800, Type.MEAT));
    }

    @Test
    void testSummingInt() {
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));

        assertThat(totalCalories).isEqualTo(4300);
    }

    @Test
    void testAveragingInt() {
        Double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        assertThat(avgCalories).isEqualTo(477.77777777777777);
    }

    @Test
    void testSummarizingInt() {
        IntSummaryStatistics menuStatics = menu.stream().collect(summarizingInt(Dish::getCalories));
        System.out.println("menuStatics = " + menuStatics);
        // menuStatics = IntSummaryStatistics{count=9, sum=4300, min=120, average=477.777778, max=800}
    }

    @Test
    void testJoining() {
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        System.out.println("shortMenu = " + shortMenu);

        // 오버로드된 joining 팩토리 메서드
        String eachShortMenu = menu.stream().map(Dish::getName).collect(joining(","));
        System.out.println("eachShortMenu = " + eachShortMenu);
    }
}

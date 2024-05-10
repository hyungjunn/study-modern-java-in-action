package com.hyungjunn.modern_java_in_action._06_collector;

import com.hyungjunn.modern_java_in_action._04_store.Dish;
import com.hyungjunn.modern_java_in_action._04_store.Type;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static com.hyungjunn.modern_java_in_action._04_store.Type.*;
import static com.hyungjunn.modern_java_in_action._06_collector.CaloricLevel.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.entry;

public class GroupingTest {
    @Test
    void testGroupDishesByType() {
        Map<Type, List<Dish>> dishesByType = Grouping.groupDishesByType();

        assertThat(dishesByType).hasSize(3);
        System.out.println(dishesByType);
    }

    @Test
    void testGroupByCaloricLevel() {
        Map<CaloricLevel, List<Dish>> dishesByCaloricLevel = Grouping.groupDishesByCaloricLevel();

        assertThat(dishesByCaloricLevel).hasSize(3);
    }

    @Test
    void testGroupCaloricDishesByType() {
        Map<Type, List<Dish>> caloricDishesByType = Grouping.groupCaloricDishesByType();

        assertThat(caloricDishesByType).hasSize(3);
        // 평범하고 단순하게 생각한 코드의 결과는
        // 예상과 다르게 2가 나온다. => 왜? filter 로 이미 칼로리가 500을 초과하는게 걸리지니
        // Fish 타입은 키 버킷이 생성되지 않게 된다
    }

    @Test
    void testGroupDishNamesByType() {
        Map<Type, List<String>> dishNamesByType = Grouping.groupDishNamesByType();
        System.out.println(dishNamesByType);
    }

    @Test
    void testGroupDishTagsByType() {
        Map<Type, Set<String>> dishTagsByType = Grouping.groupDishTagsByType();
        System.out.println(dishTagsByType);
    }

    @Test
    void testGroupDishedByTypeAndCaloricLevel() {
        Map<Type, Map<CaloricLevel, List<Dish>>> groupedDish = Grouping.groupDishedByTypeAndCaloricLevel();
        System.out.println(groupedDish);
    }

    @Test
    void testGroupCountByType() {
        Map<Type, Long> typesCount = Grouping.countDishesType();
        System.out.println(typesCount);
    }

    @Test
    void testMostCaloricDishesByType() {
        Map<Type, Optional<Dish>> mostCaloricByType = Grouping.mostCaloricDishesByType();
        System.out.println(mostCaloricByType);
    }

    @Test
    void testMostCaloricDishesByTypeWithoutOptionals() {
        Map<Type, Dish> mostCaloricByType = Grouping.mostCaloricDishesByTypeWithoutOptionals();
        System.out.println(mostCaloricByType);
    }

    @ParameterizedTest
    @CsvSource({
            "FISH, 850",
            "OTHER, 1550",
            "MEAT, 1900"
    })
    void testSumCaloriesByType(Type key, Integer value) {
        Map<Type, Integer> totalCaloriesByType = Grouping.sumCaloriesByType();
        System.out.println(totalCaloriesByType);
        assertThat(totalCaloriesByType)
                .containsEntry(key, value);
    }

    @ParameterizedTest
    @MethodSource("provideTypeAndExpectedCaloricLevels")
    void testCaloricLevelsByType(Type type, Set<CaloricLevel> expectedCaloricLevels) {
        Map<Type, Set<CaloricLevel>> caloricLevelsByType = Grouping.caloricLevelsByType();

        assertThat(caloricLevelsByType).containsEntry(type, expectedCaloricLevels);
    }

    private static Stream<Arguments> provideTypeAndExpectedCaloricLevels() {
        return Stream.of(
                Arguments.of(MEAT, EnumSet.of(DIET, FAT, NORMAL)),
                Arguments.of(OTHER, EnumSet.of(DIET, NORMAL)),
                Arguments.of(FISH, EnumSet.of(DIET, NORMAL))
        );
    }
}

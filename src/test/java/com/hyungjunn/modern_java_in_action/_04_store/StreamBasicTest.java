package com.hyungjunn.modern_java_in_action._04_store;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;
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
}

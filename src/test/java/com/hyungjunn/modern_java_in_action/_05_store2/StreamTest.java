package com.hyungjunn.modern_java_in_action._05_store2;

import com.hyungjunn.modern_java_in_action._04_store.Dish;
import com.hyungjunn.modern_java_in_action._04_store.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.hyungjunn.modern_java_in_action._04_store.DishTest.menu;

public class StreamTest {
    @Test
    void testExternalIteration() {
        List<Dish> vegetarianDishes = Order.orderVegetarianByExternal(menu);

        Assertions.assertThat(vegetarianDishes).hasSize(4);
    }
}

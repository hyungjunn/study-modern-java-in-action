package com.hyungjunn.modern_java_in_action._03_fruit;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FruitTest {
    @Test
    void testFruit() {
        Fruit apple = Fruit.giveMeFruit("APPLE", 110);
        Fruit orange = Fruit.giveMeFruit("ORANGE", 150);

        assertThat(apple).isEqualTo(new Apple(110));
        assertThat(orange).isEqualTo(new Orange(150));
    }
}

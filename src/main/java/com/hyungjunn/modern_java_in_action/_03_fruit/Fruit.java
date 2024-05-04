package com.hyungjunn.modern_java_in_action._03_fruit;

import com.hyungjunn.modern_java_in_action._02_apples.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Fruit {
    private final int weight;
    private final Color color;

    protected Fruit(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    private static Map<String, Function<Integer, Fruit>> fruitMap = new HashMap<>();

    static {
        fruitMap.put("apple", Apple::new);
        fruitMap.put("orange", Orange::new);
    }

    public static Fruit giveMeFruit(String fruit, Integer weight) {
        return fruitMap.get(fruit.toLowerCase())
                .apply(weight);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Fruit fruit = (Fruit) object;
        return weight == fruit.weight && color == fruit.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, color);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}

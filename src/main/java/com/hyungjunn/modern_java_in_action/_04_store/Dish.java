package com.hyungjunn.modern_java_in_action._04_store;

import java.util.Objects;

public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public int getCalories() {
        return this.calories;
    }

    public String getName() {
        return this.name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public boolean isMeat() {
        return type == Type.MEAT;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Dish dish = (Dish) object;
        return vegetarian == dish.vegetarian && calories == dish.calories && Objects.equals(name, dish.name) && type == dish.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vegetarian, calories, type);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                '}';
    }
}

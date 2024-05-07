package com.hyungjunn.modern_java_in_action._04_store;

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
}

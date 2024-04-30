package com.hyungjunn.modern_java_in_action._02_apples;

public class Apple {
    private final int weight;
    private final String color;

    public Apple(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

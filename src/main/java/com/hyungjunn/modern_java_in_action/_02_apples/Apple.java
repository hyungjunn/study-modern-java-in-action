package com.hyungjunn.modern_java_in_action._02_apples;

public class Apple {
    private final int weight;
    private final Color color;

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }

    public boolean isGreen() {
        return color.isGreen();
    }

    public Color getColor() {
        return color;
    }
}

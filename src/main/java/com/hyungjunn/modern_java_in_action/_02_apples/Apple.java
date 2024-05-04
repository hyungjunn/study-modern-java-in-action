package com.hyungjunn.modern_java_in_action._02_apples;

public class Apple {
    private final int weight;
    private final Color color;
    private final String country;

    public Apple() {
        this(0);
    }

    public Apple(Integer integer) {
        this(integer, null, null);
    }

    public Apple(int weight, Color color) {
        this(weight, color, null);
    }

    public Apple(int weight, Color color, String country) {
        this.weight = weight;
        this.color = color;
        this.country = country;
    }

    public boolean isGreen() {
        return color.isGreen();
    }

    public boolean isSameColor(Color color) {
        return this.color == color;
    }

    public Color getColor() {
        return color;
    }

    public boolean isWeightAbove(int weight) {
        return this.weight > weight;
    }

    public boolean isRed() {
        return this.color.isRed();
    }

    public int getWeight() {
        return this.weight;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                ", country='" + country + '\'' +
                '}';
    }
}

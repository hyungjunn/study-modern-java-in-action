package com.hyungjunn.modern_java_in_action._03_fruit;

public class Color {
    public Color(int a, int b, int c) {

    }

    public static TriFunction<Integer, Integer, Integer, Color> colorFactory = Color::new;

    public static void main(String[] args) {
        System.out.println(colorFactory);
    }
}

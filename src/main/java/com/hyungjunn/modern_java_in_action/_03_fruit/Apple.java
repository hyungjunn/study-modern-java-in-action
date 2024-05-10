package com.hyungjunn.modern_java_in_action._03_fruit;

import com.hyungjunn.modern_java_in_action._02_apples.Color;

public class Apple extends Fruit{
    public Apple(Integer weight) {
        this(weight, null);
    }

    public Apple(int weight, Color color) {
        super(weight, color);
    }
}

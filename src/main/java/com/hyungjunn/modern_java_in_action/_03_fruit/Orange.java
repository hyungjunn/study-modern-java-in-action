package com.hyungjunn.modern_java_in_action._03_fruit;

import com.hyungjunn.modern_java_in_action._02_apples.Color;

public class Orange extends Fruit{
    public Orange(Integer weight) {
        this(weight, null);
    }

    public Orange(int weight, Color color) {
        super(weight, color);
    }
}

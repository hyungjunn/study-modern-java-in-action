package com.hyungjunn.modern_java_in_action._02_apples;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.isGreen()) {
                result.add(apple);
            }
        }
        return result;
    }
}

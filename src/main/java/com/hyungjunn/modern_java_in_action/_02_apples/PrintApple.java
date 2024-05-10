package com.hyungjunn.modern_java_in_action._02_apples;

import java.util.List;

public class PrintApple {
    public static void prettyPrintApple(
            List<Apple> inventory,
            AppleFormatter appleFormatter
    ) {
        for (Apple apple : inventory) {
            String output = appleFormatter.accept(apple);
            System.out.println(output);
        }
    }
}

package com.hyungjunn.modern_java_in_action._02_apples.strategy;

import com.hyungjunn.modern_java_in_action._02_apples.Apple;
import com.hyungjunn.modern_java_in_action._02_apples.AppleFormatter;

public class AppleSimpleFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}

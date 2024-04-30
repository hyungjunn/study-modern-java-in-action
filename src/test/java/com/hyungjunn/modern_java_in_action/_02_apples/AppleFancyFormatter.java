package com.hyungjunn.modern_java_in_action._02_apples;

public class AppleFancyFormatter implements AppleFormatter {
    @Override
    public String accept(Apple apple) {
        String characteristics = apple.isWeightAbove(150) ? "heavy" : "light";
        return "A " + characteristics + " " + apple.getColor() + " apple";
    }
}

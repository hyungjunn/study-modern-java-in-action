package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.strategy;

public class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}

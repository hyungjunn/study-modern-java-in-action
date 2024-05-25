package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.strategy;

public class isNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}

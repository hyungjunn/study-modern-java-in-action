package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.chain_of_responsibility;

public class SpellCheckerProcessing extends ProcessingObject<String> {
    @Override
    protected String handleWork(String text) {
        return text.replaceAll("labda", "lambda");
    }
}

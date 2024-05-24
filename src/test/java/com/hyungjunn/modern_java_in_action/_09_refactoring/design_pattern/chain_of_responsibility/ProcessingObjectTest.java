package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.chain_of_responsibility;

import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.function.UnaryOperator;

class ProcessingObjectTest {

    @Test
    void test() {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();

        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?");
        System.out.println(result);
    }

    @Test
    void testLambda() {
        UnaryOperator<String> headerProcessing = (String text) -> "From Hyungjunn, Karina, Winter: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing);

        String result = pipeline.apply("Aren't labdas really sexy?");
        System.out.println(result);
    }
}

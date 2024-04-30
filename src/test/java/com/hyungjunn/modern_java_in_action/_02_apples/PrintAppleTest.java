package com.hyungjunn.modern_java_in_action._02_apples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.hyungjunn.modern_java_in_action._02_apples.Color.GREEN;
import static com.hyungjunn.modern_java_in_action._02_apples.Color.RED;

public class PrintAppleTest {
    private List<Apple> inventory;

    @BeforeEach
    void setUp() {
        inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED)
        );
    }

    @Test
    void printFancy() {
        PrintApple.prettyPrintApple(inventory, new AppleFancyFormatter());
    }

    @Test
    void printSimple() {
        PrintApple.prettyPrintApple(inventory, new AppleSimpleFormatter());
    }
}

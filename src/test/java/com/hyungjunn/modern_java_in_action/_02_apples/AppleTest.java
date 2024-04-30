package com.hyungjunn.modern_java_in_action._02_apples;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppleTest {
    private Apple apple;

    @BeforeEach
    void setUp() {
        apple = new Apple(100, Color.GREEN);
    }

    @Test
    void isGreen() {
        boolean isGreen = apple.isGreen();

        assertThat(isGreen).isTrue();
    }

    @Test
    void isWeightAbove() {
        boolean isWeightAbove = apple.isWeightAbove(150);

        assertThat(isWeightAbove).isFalse();
    }

    @Test
    void isSameColor() {
        boolean sameColor = apple.isSameColor(Color.GREEN);

        assertThat(sameColor).isTrue();
    }

    @Test
    void isRed() {
        boolean isRed = apple.isRed();

        assertThat(isRed).isFalse();
    }
}

package com.hyungjunn.modern_java_in_action._02_apples;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppleTest {
    @Test
    void isGreen() {
        boolean isGreen = new Apple(100, Color.GREEN).isGreen();

        assertThat(isGreen).isTrue();
    }
}

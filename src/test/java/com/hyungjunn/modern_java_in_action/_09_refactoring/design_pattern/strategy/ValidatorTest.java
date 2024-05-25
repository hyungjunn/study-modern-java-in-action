package com.hyungjunn.modern_java_in_action._09_refactoring.design_pattern.strategy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @Test
    void testIsAllLowerCase() {
        String s = "SSSSS";
        String s1 = "sssss";
        Validator validator = new Validator(new IsAllLowerCase());

        assertThat(validator.validate(s)).isFalse();
        assertThat(validator.validate(s1)).isTrue();
    }

    @Test
    void testIsNumeric() {
        String s = "11111";
        Validator validator = new Validator(new isNumeric());

        assertThat(validator.validate(s)).isTrue();
    }

    @Test
    void testIsAllUpperCase() {
        String input = "SSSSS";
        String lowerInput = "sssss";

        Validator validator = new Validator((String s) -> s.matches("[A-Z]+"));

        assertThat(validator.validate(input)).isTrue();
        assertThat(validator.validate(lowerInput.toUpperCase())).isTrue();
    }
}

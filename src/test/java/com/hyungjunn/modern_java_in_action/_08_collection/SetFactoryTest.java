package com.hyungjunn.modern_java_in_action._08_collection;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class SetFactoryTest {
    @Test
    void testSetException() {
        assertThatThrownBy(() -> Set.of("Karina", "Karina", "Karina"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

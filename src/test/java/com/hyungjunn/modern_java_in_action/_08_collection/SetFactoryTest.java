package com.hyungjunn.modern_java_in_action._08_collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class SetFactoryTest {
    @Test
    void testSetException() {
        Assertions.assertThatThrownBy(() -> Set.of("Karina", "Karina", "Karina"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

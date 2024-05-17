package com.hyungjunn.modern_java_in_action._08_collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UnsupportedOperationExceptionTest {
    @Test
    void testAsListException() {
        List<String> friends = Arrays.asList("Karina", "Winter");
        // 갱신은 허용이 된다
        friends.set(0, "giselle");
        // 그러나, 요소를 추가하거나 삭제를 할 수 없다
        Assertions.assertThatThrownBy(() ->  friends.add("ningning"))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}

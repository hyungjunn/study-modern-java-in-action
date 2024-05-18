package com.hyungjunn.modern_java_in_action._08_collection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ListTest {
    @Test
    void testAsListException() {
        List<String> friends = Arrays.asList("Karina", "Winter");
        // 갱신은 허용이 된다
        friends.set(0, "giselle");
        // 그러나, 요소를 추가하거나 삭제를 할 수 없다
        Assertions.assertThatThrownBy(() ->  friends.add("ningning"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void testListOfException() {
        List<String> friends = List.of("Karina", "Winter");

        Assertions.assertThatThrownBy(() -> friends.add("giselle"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void testListOfException2() {
        List<String> friends = List.of("Karina", "Winter");
        // List.of(..) 는 Arrays.asList 와 다르게 갱신도 되지 않음
        Assertions.assertThatThrownBy(() -> friends.set(0, "ningning"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void testListOfException3() {
        // Arrays.asList 와 다르게 요소로 null 요소를 금지함
        Assertions.assertThatThrownBy(() -> List.of(null, null))
                .isInstanceOf(NullPointerException.class);
    }
}

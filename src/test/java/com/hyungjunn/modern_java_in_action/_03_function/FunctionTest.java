package com.hyungjunn.modern_java_in_action._03_function;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {
    // T 타입의 입력을 받아, R 타입의 결과를 반환하는 메서드
    private <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(f.apply(t));
        }
        return result;
    }

    @Test
    void apply() {
        List<Integer> l = map(
                Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length()
        );

        assertThat(l.size()).isEqualTo(3);
        assertThat(l.get(0)).isEqualTo(7);
        assertThat(l.get(1)).isEqualTo(2);
        assertThat(l.get(2)).isEqualTo(6);
    }
}

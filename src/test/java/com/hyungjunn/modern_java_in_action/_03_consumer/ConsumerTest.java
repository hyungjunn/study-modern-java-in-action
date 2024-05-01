package com.hyungjunn.modern_java_in_action._03_consumer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ConsumerTest {
    private <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    @Test
    void forEach() {
        // Consumer 함수형 인터페이스의 추상 메서드인 accept 의 동작을 람다 표현식으로 다음과 같이 정의한다
        forEach(
                Arrays.asList(1, 2, 3, 4, 5),
                i -> System.out.println(i)
        );
    }
}

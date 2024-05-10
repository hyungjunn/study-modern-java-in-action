package com.hyungjunn.modern_java_in_action._03_file;

import org.junit.jupiter.api.Test;

public class RunTest {
    @Test
    void runByLambda() {
        Runnable r1 = () -> System.out.println("Hello World 1");
        Run.process(r1);
    }

    @Test
    void runByAnonymous() {
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World 2");
            }
        };
        Run.process(r2);
    }

    @Test
    void runByDirectLambda() {
        // 이렇게 void 타입을 가진 함수형 인터페이스 Runnable 의 추상 메서드 run()의 구현을
        // 람다 표현식이 직접 전달한다
        Run.process(() -> System.out.println("Hello World 3"));
    }
}

package com.hyungjunn.modern_java_in_action._03_construct_refererence;

import com.hyungjunn.modern_java_in_action._02_apples.Apple;
import com.hyungjunn.modern_java_in_action._02_apples.Color;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.hyungjunn.modern_java_in_action._03_function.FunctionTest.map;

public class ConstructReferenceTest {
    @Test
    void test() {
        Supplier<Apple> c1 = Apple::new;
        Apple a1 = c1.get();

        // 위의 메서드 참조와 동일한 로직
        Supplier<Apple> c2 = () -> new Apple();
        Apple a2 = c1.get();

        // Apple(Integer weight)라는 시그니처를 갖는 생성자는 Function 인터페이스의 시그니처와 같다
        Function<Integer, Apple> c3 = Apple::new;
        Apple a3 = c3.apply(110);

        // 위의 메서드 참조와 동일한 로직
        Function<Integer, Apple> c4 = (weight) -> new Apple(weight);
        Apple a4 = c4.apply(110);

        // T 타입을 입력받아 R 타입을 반환하는 메서드를 이용
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        // FunctionTest 의 map 을 사용하기 위해 static 메서드로 바꾸어 줌
        // weight 만 인자로 가지는 Apple(Integer weight) 생성자
        List<Apple> apples = map(weights, Apple::new);
        // [Apple{weight=7, color=null}, Apple{weight=3, color=null}, Apple{weight=4, color=null}, Apple{weight=10, color=null}]
        System.out.println(apples);
    }

    @Test
    void test2() {
        // 이번에는 Apple(Integer weight, Color color) 처럼 두 인자를 가지는 생성자를 참조해보자
        // 시그니처는 Integer, Color 타입을 인풋, Apple 타입을 아웃풋
        // <Integer, Color, Apple> => BiFunction
        // BiFunction<Integer, Color, Apple> c5 = (weight, color) -> new Apple(weight, color);
        BiFunction<Integer, Color, Apple> c5 = Apple::new;
        Apple redAnd110gApple = c5.apply(110, Color.RED);
        // 즉, 정적 팩터리 메서드를 만드는 과정과 비슷하다
        // 인스턴스화 하지 않고 생성사에 접근할 수 있다
        System.out.println("redAnd110gApple = " + redAnd110gApple);
    }
}

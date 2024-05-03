package com.hyungjunn.modern_java_in_action._03_fruit;

@FunctionalInterface
public interface TriFunction<T, U, V, R> {
    // Color(int, int, int) 처럼 인수가 세 개인 생성자의 생성자 참조를 사용하려면?
    // Color::new
    // input (int, int, int) output Color 가 되어야함
    R apply(T t, U u, V v);
}

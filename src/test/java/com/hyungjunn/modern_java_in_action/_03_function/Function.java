package com.hyungjunn.modern_java_in_action._03_function;

@FunctionalInterface
public interface Function<T, R> {
    R apply(T t);
}

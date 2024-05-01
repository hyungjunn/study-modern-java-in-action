package com.hyungjunn.modern_java_in_action._03_consumer;

@FunctionalInterface
public interface Consumer<T> {
    void accept(T t);
}

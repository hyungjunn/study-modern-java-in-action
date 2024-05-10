package com.hyungjunn.modern_java_in_action._02_apples;

/**
 * Strategy_pattern
 *
 * 각 알고리즘을 캡슐화하는 알고리즘 패밀리를 정의,
 * 런타임에 알고리즘을 선택하는 기법
 *
 * ApplePredicate 가 알고리즘 패밀리
 * ApplePredicate 를 구현한 구현체가 전략이다.
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}

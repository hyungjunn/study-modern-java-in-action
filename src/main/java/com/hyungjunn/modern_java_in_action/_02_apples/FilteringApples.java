package com.hyungjunn.modern_java_in_action._02_apples;

import java.util.ArrayList;
import java.util.List;

/**
 * 계속 변화하는 요구사항 -> 동작 파라미터화로 해결가능
 * 리스트의 모든 요소에 대해서 '어떤 동작'을 수행할 수 있음.
 * 리스트 관련 작업을 끝낸 다음에 '어떤 다른 동작'을 수행할 수 있음.
 * 에러가 발생하면 '정해진 어떤 다른 동작'을 수행할 수 있음.
 */
public class FilteringApples {
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.isGreen()) {
                result.add(apple);
            }
        }
        return result;
    }
}

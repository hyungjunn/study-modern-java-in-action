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

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.isSameColor(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.isWeightAbove(weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    // 색이나 무게 중 어떤 것을 기준으로 필터링할지 정해주는 flag 를 추가
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ((flag && apple.getColor() == color) || (!flag && apple.isWeightAbove(weight))) {
                result.add(apple);
            }
        }
        return result;
    }
}

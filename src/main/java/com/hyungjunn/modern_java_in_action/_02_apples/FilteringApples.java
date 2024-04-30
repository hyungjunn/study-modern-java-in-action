package com.hyungjunn.modern_java_in_action._02_apples;

import java.util.ArrayList;
import java.util.List;

/**
 * 계속 변화하는 요구사항 -> 동작 파라미터화로 해결가능
 * <p>
 * 바뀌는 요구사항에 따라 코드를 파라미터를 바꾸면서 새로 메서드를 만드는 것은 올바르지 않음
 * <p>
 * 계속 바뀌는 부분은 if 절 안의 boolean 값이므로
 * 참 거짓을 반환하는 프레디케이트를 정의하면 된다
 * <p>
 * 그러나, 이렇게 전략패턴을 이용해서 동작 파라미터화를 하면, 클래스를 번거롭게 계속 생성시켜줘야 한다.
 * 이를 익명클래스로 해결할 수 있다.
 * 익명클래스를 사용해서 클래스 선언과 인스턴스 생성을 동시에 처리할 수 있다.
 * <p>
 * 하지만, 여전히 문제가 있다. 코드가 너무 장황해진다는 점이다.
 * 이를 해결하기 위해 람다 표현식을 활용할 수 있다.
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

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate applePredicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (applePredicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}

package com.hyungjunn.modern_java_in_action._09_refactoring.debugging;

import java.util.Arrays;
import java.util.List;

public class Peek {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5);
        numbers.stream()
                .map(x -> x + 17)
                .filter(x -> x % 2 == 0)
                .limit(3)
                .forEach(System.out::println);

        numbers.stream()
                .peek(x -> System.out.println("from stream111: " + x))
                .map(x -> x + 17)
                .peek(x -> System.out.println("after map222: " + x))
                .filter(x -> x % 2 == 0)
                .peek(x -> System.out.println("after filter333: " + x))
                .limit(3)
                .peek(x -> System.out.println("after limit444: " + x))
                .toList();
    }
}

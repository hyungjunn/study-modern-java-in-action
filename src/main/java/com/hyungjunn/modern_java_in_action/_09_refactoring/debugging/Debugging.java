package com.hyungjunn.modern_java_in_action._09_refactoring.debugging;

import com.hyungjunn.modern_java_in_action._09_refactoring.testing.Point;

import java.util.Arrays;
import java.util.List;

public class Debugging {
    public static void main(String[] args) {
        // List<Point> points = Arrays.asList(new Point(12, 2), null);
        // points.stream()
        //         .map(Point::getX).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(1, 2, 3);
        numbers.stream()
                .map(Debugging::divideByZero).forEach(System.out::println);
    }

    public static int divideByZero(int n) {
        return n / 0;
    }
}

package com.hyungjunn.modern_java_in_action._09_refactoring.testing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.hyungjunn.modern_java_in_action._02_apples.FilteringApples.filter;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @Test
    void testMoveRightBy() {
        Point point = new Point(5, 5);
        Point point1 = point.moveRightBy(5);

        assertThat(point1.getX()).isEqualTo(10);
        assertThat(point1.getY()).isEqualTo(5);
    }

    @Test
    void testComparingTwoPoints() {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);
        int compare = Point.compareByXAndThenY.compare(p1, p2);
        assertThat(compare).isEqualTo(-1);
    }

    @Test
    void testMoveAllPointsRightBy() {
        List<Point> points = Arrays.asList(new Point(5, 5), new Point(10, 5));
        List<Point> expectedPoints = Arrays.asList(new Point(15, 5), new Point(20, 5));
        List<Point> newPoints = Point.moveAllPointsRightBy(points, 10);
        assertThat(newPoints).isEqualTo(expectedPoints);
    }

    @Test
    void testFilter() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> even = filter(numbers, i -> i % 2 == 0);
        List<Integer> smallerThanThree = filter(numbers, i -> i < 3);
        assertThat(Arrays.asList(2, 4)).isEqualTo(even);
        assertThat(Arrays.asList(1, 2)).isEqualTo(smallerThanThree);
    }
}

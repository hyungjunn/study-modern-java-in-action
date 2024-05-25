package com.hyungjunn.modern_java_in_action._09_refactoring.testing;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Point {
    private final int x;
    private final int y;

    public final static Comparator<Point> compareByXAndThenY =
            Comparator.comparing(Point::getX).thenComparing(Point::getY);

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point moveRightBy(int x) {
        return new Point(this.x + x, this.y);
    }

    public static List<Point> moveAllPointsRightBy(List<Point> points, int x1) {
        return points.stream()
                .map(p -> new Point(p.getX() + x1, p.getY()))
                .collect(toList());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Point point = (Point) object;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

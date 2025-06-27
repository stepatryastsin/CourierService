package org.example.entity;

import java.util.Objects;

public final class Point {

    private final float x;
    private final float y;

    public Point(float x, float y) {
        if (!isValid(x, y)) {
            throw new IllegalArgumentException(
                    String.format("Invalid point: (%.2f, %.2f)", x, y));
        }
        this.x = x;
        this.y = y;
    }


    private static boolean isValid(float x, float y) {
        return x >= WorldConstants.MIN_X &&
               x <= WorldConstants.MAX_X &&
               y >= WorldConstants.MIN_Y &&
               y <=WorldConstants.MAX_Y;
    }

    public float getX() { return x; }
    public float getY() { return y; }

    public float distanceTo(Point other) {
        return (float) Math.hypot(this.x - other.x, this.y - other.y);
    }
    public float distanceTo(float x,float y) {
        return (float) Math.hypot(this.x - x, this.y - y);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point p = (Point) o;
        return Float.compare(p.x, x) == 0
                && Float.compare(p.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

package org.slicedPotatoes.adventOfCode._2015.day03;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return x * 31 + y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Point p) {
            return x == p.x && y == p.y;
        }

        return false;
    }
}

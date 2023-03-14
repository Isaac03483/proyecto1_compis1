package com.mio.server.models;

import com.mio.server.builders.PointBuilder;

public class Point {

    private final Double posX;
    private final Double posY;

    public Point(PointBuilder builder) {
        this.posX = builder.getPosX();
        this.posY = builder.getPosY();
    }

    public Double getPosX() {
        return posX;
    }


    public Double getPosY() {
        return posY;
    }

    @Override
    public String toString() {
        return "Point " +
                "posX " + posX +
                " posY " + posY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (!posX.equals(point.posX)) return false;
        return posY.equals(point.posY);
    }

    @Override
    public int hashCode() {
        int result = posX.hashCode();
        result = 31 * result + posY.hashCode();
        return result;
    }
}

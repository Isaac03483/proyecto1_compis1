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
        return "Point{" +
                "posX=" + posX +
                ", posY=" + posY +
                '}';
    }
}

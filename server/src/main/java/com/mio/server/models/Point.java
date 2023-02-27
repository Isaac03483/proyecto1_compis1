package com.mio.server.models;

import com.mio.server.builders.PointBuilder;

public class Point {

    private final Integer posX;
    private final Integer posY;

    public Point(PointBuilder builder) {
        this.posX = builder.getPosX();
        this.posY = builder.getPosY();
    }

    public Integer getPosX() {
        return posX;
    }


    public Integer getPosY() {
        return posY;
    }
}

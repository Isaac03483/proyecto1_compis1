package com.mio.server.models;

import com.mio.server.builders.BoardBuilder;

public class Board {

    private final Point point;
    private final Integer type;

    public Board(BoardBuilder builder) {
        this.point = builder.getPoint();
        this.type = builder.getType();
    }

    public Point getPoint() {
        return point;
    }

    public Integer getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Board{" +
                "point=" + point +
                ", type=" + type +
                '}';
    }
}

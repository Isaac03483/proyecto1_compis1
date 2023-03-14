package com.mio.server.models;

import com.mio.server.builders.BoardBuilder;

public class Board {

    private final Point point;
    private final String type;

    public Board(BoardBuilder builder) {
        this.point = builder.getPoint();
        this.type = builder.getType();
    }

    public Point getPoint() {
        return point;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Board{" +
                "point=" + point +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (!point.equals(board.point)) return false;
        return type.equals(board.type);
    }

    @Override
    public int hashCode() {
        int result = point.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}

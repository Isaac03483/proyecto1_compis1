package com.mio.cliente.boxworld.builders;

import com.mio.cliente.boxworld.models.Board;
import com.mio.cliente.boxworld.models.Point;

import java.io.Serializable;

public class BoardBuilder implements Serializable {

    private Point point;
    private String type;

    public BoardBuilder() {
    }

    public BoardBuilder withPoint(Point point){
        this.point = point;
        return this;
    }

    public BoardBuilder withType(String type){
        this.type = type;
        return this;
    }

    public Board build(){
        return new Board(this);
    }

    public void clean(){
        this.point = null;
        this.type = null;
    }

    public Point getPoint() {
        return point;
    }

    public String getType() {
        return type;
    }
}

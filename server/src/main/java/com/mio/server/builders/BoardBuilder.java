package com.mio.server.builders;

import com.mio.server.exceptions.DuplicateAttributeException;
import com.mio.server.models.Board;
import com.mio.server.models.Point;

public class BoardBuilder {

    private Point point;
    private String type;

    public BoardBuilder() {
    }

    public BoardBuilder withPoint(Point point){
        if(this.point != null){
            throw  new DuplicateAttributeException("El punto ya ha sido declarado");

        }
        this.point = point;
        return this;
    }

    public BoardBuilder withType(String type){
        if(this.type != null){
            throw new DuplicateAttributeException("El tipo ya ha sido declarado");
        }
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

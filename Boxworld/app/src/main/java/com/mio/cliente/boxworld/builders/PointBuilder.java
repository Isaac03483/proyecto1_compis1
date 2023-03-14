package com.mio.cliente.boxworld.builders;

import com.mio.cliente.boxworld.models.Point;

public class PointBuilder {

    private Integer posX;
    private Integer posY;

    public PointBuilder() {
    }

    public PointBuilder withPosX(Integer posX){
        this.posX = posX;
        return this;
    }

    public PointBuilder withPosY(Integer posY){
        this.posY = posY;
        return this;
    }

    public Point build(){
        return new Point(this);
    }

    public void clean(){
        this.posX = null;
        this.posY = null;
    }

    public Integer getPosX() {
        return posX;
    }

    public Integer getPosY() {
        return posY;
    }
}

package com.mio.server.builders;

import com.mio.server.models.Point;

public class PointBuilder {

    private Integer posX;
    private Integer posY;

    public PointBuilder() {
    }

    public PointBuilder withPosX(Integer posX){
        if(this.posX != null){
            throw  new RuntimeException("la posición X ya ha sido declarada");

        }
        this.posX = posX;
        return this;
    }

    public PointBuilder withPosY(Integer posY){
        if(this.posY != null){
            throw  new RuntimeException("la posición X ya ha sido declarada");

        }
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

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}

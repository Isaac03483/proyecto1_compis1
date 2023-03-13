package com.mio.server.builders;

import com.mio.server.exceptions.DuplicateAttributeException;
import com.mio.server.models.Point;

public class PointBuilder {

    private Double posX;
    private Double posY;

    public PointBuilder() {
    }

    public PointBuilder withPosX(Double posX){
        if(this.posX != null){
            throw  new DuplicateAttributeException("la posición X ya ha sido declarada");

        }
        this.posX = posX;
        return this;
    }

    public PointBuilder withPosY(Double posY){
        if(this.posY != null){
            throw  new DuplicateAttributeException("la posición X ya ha sido declarada");

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

    public Double getPosX() {
        return posX;
    }

    public Double getPosY() {
        return posY;
    }
}

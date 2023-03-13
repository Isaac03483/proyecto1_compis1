package com.mio.server.builders;

import com.mio.server.exceptions.DuplicateAttributeException;
import com.mio.server.models.WorldConfig;

public class WConfigBuilder {

    private String boxColor;
    private String boxOnTargetColor;
    private String targetColor;
    private String brickColor;
    private String hallColor;
    private String undefinedColor;
    private String playerColor;

    public WConfigBuilder() {
    }

    public WConfigBuilder withBoxColor(String boxColor){
        if(this.boxColor != null){
            throw new DuplicateAttributeException("El color de las cajas ya ha sido declarado");
        }
        this.boxColor = boxColor;
        return this;
    }

    public WConfigBuilder withBoxOnTargetColor(String boxOnTargetColor){
        if(this.boxOnTargetColor != null){
            throw new DuplicateAttributeException("El color de las cajas ya ha sido declarado");
        }
        this.boxOnTargetColor = boxOnTargetColor;
        return this;
    }

    public WConfigBuilder withTargetColor(String targetColor){
        if(this.targetColor != null){
            throw new DuplicateAttributeException("El color de las cajas ya ha sido declarado");
        }
        this.targetColor = targetColor;
        return this;
    }

    public WConfigBuilder withBrickColor(String brickColor){
        if(this.brickColor != null){
            throw new DuplicateAttributeException("El color de las cajas ya ha sido declarado");
        }
        this.brickColor = brickColor;
        return this;
    }

    public WConfigBuilder withHallColor(String hallColor){
        if(this.hallColor != null){
            throw new DuplicateAttributeException("El color de las cajas ya ha sido declarado");
        }
        this.hallColor =hallColor;
        return this;
    }

    public WConfigBuilder withUndefinedColor(String undefinedColor){
        if(this.undefinedColor != null){
            throw new DuplicateAttributeException("El color de las cajas ya ha sido declarado");
        }
        this.undefinedColor= undefinedColor;
        return this;
    }

    public WConfigBuilder withPlayerColor(String playerColor){
        if(this.playerColor != null){
            throw new DuplicateAttributeException("El color de las cajas ya ha sido declarado");
        }
        this.playerColor= playerColor;
        return this;
    }

    public WorldConfig build(){
        return new WorldConfig(this);
    }

    public void clean(){
        this.boxColor = null;
        this.boxOnTargetColor = null;
        this.targetColor = null;
        this.brickColor = null;
        this.hallColor = null;
        this.undefinedColor = null;
        this.playerColor = null;
    }

    public String getBoxColor() {
        return boxColor;
    }

    public String getBoxOnTargetColor() {
        return boxOnTargetColor;
    }

    public String getTargetColor() {
        return targetColor;
    }

    public String getBrickColor() {
        return brickColor;
    }

    public String getHallColor() {
        return hallColor;
    }

    public String getUndefinedColor() {
        return undefinedColor;
    }

    public String getPlayerColor() {
        return playerColor;
    }
}

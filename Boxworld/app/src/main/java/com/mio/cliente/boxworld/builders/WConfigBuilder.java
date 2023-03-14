package com.mio.cliente.boxworld.builders;

import com.mio.cliente.boxworld.models.WConfig;

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
        this.boxColor = boxColor;
        return this;
    }

    public WConfigBuilder withBoxOnTargetColor(String boxOnTargetColor){
        this.boxOnTargetColor = boxOnTargetColor;
        return this;
    }

    public WConfigBuilder withTargetColor(String targetColor){

        this.targetColor = targetColor;
        return this;
    }

    public WConfigBuilder withBrickColor(String brickColor){
        this.brickColor = brickColor;
        return this;
    }

    public WConfigBuilder withHallColor(String hallColor){
        this.hallColor =hallColor;
        return this;
    }

    public WConfigBuilder withUndefinedColor(String undefinedColor){
        this.undefinedColor= undefinedColor;
        return this;
    }

    public WConfigBuilder withPlayerColor(String playerColor){
        this.playerColor= playerColor;
        return this;
    }

    public WConfig build(){
        return new WConfig(this);
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

package com.mio.server.models;

import com.mio.server.builders.WConfigBuilder;

public class WorldConfig {

    private final String boxColor;
    private final String boxOnTargetColor;
    private final String targetColor;
    private final String brickColor;
    private final String hallColor;
    private final String undefinedColor;
    private final String playerColor;

    public WorldConfig(WConfigBuilder builder) {
        this.boxColor = builder.getBoxColor();
        this.boxOnTargetColor = builder.getBoxOnTargetColor();
        this.targetColor = builder.getTargetColor();
        this.brickColor = builder.getBrickColor();
        this.hallColor = builder.getHallColor();
        this.undefinedColor = builder.getUndefinedColor();
        this.playerColor = builder.getPlayerColor();
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

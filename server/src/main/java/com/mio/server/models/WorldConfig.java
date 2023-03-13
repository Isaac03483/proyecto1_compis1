package com.mio.server.models;

import com.mio.server.builders.WConfigBuilder;

public class WorldConfig {

    public static final WorldConfig defaultConfig = new WorldConfig(
            new WConfigBuilder().withBoxColor("#ffff00")
                    .withBoxOnTargetColor("#fe0002")
                    .withTargetColor("#d6fe0a")
                    .withBrickColor("#bdbebf")
                    .withHallColor("#0001ff")
                    .withUndefinedColor("#303030")
                    .withPlayerColor("#ff00f7")
    );

    private String boxColor;
    private String boxOnTargetColor;
    private String targetColor;
    private String brickColor;
    private String hallColor;
    private String undefinedColor;
    private String playerColor;

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

    public void setBoxColor(String boxColor) {
        this.boxColor = boxColor;
    }

    public void setBoxOnTargetColor(String boxOnTargetColor) {
        this.boxOnTargetColor = boxOnTargetColor;
    }

    public void setTargetColor(String targetColor) {
        this.targetColor = targetColor;
    }

    public void setBrickColor(String brickColor) {
        this.brickColor = brickColor;
    }

    public void setHallColor(String hallColor) {
        this.hallColor = hallColor;
    }

    public void setUndefinedColor(String undefinedColor) {
        this.undefinedColor = undefinedColor;
    }

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }

    @Override
    public String toString() {
        return "WorldConfig{" +
                "boxColor='" + boxColor + '\'' +
                ", boxOnTargetColor='" + boxOnTargetColor + '\'' +
                ", targetColor='" + targetColor + '\'' +
                ", brickColor='" + brickColor + '\'' +
                ", hallColor='" + hallColor + '\'' +
                ", undefinedColor='" + undefinedColor + '\'' +
                ", playerColor='" + playerColor + '\'' +
                '}';
    }
}

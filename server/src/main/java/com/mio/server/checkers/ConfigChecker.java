package com.mio.server.checkers;

import com.mio.server.models.WorldConfig;

public class ConfigChecker {

    WorldConfig config;

    public ConfigChecker(WorldConfig config) {
        this.config = config;
    }

    public void checkAll(){
        checkBoxColor();
        checkBoxOnTargetColor();
        checkTargetColor();
        checkBrickColor();
        checkHallColor();
        checkUndefinedColor();
        checkPlayerColor();
    }

    private void checkBoxColor(){

        if(config.getBoxColor() == null){
            config.setBoxColor(WorldConfig.defaultConfig.getBoxColor());
        }
    }

    private void checkBoxOnTargetColor(){

        if(config.getBoxOnTargetColor() == null){
            config.setBoxOnTargetColor(WorldConfig.defaultConfig.getBoxOnTargetColor());
        }
    }

    private void checkTargetColor(){
        if(config.getTargetColor() == null){
            config.setTargetColor(WorldConfig.defaultConfig.getTargetColor());
        }
    }

    private void checkBrickColor(){

        if(config.getBrickColor() == null){
            config.setBrickColor(WorldConfig.defaultConfig.getBrickColor());
        }
    }

    private void checkHallColor(){

        if(config.getHallColor() == null){
            config.setHallColor(WorldConfig.defaultConfig.getHallColor());
        }
    }

    private void checkUndefinedColor(){
        if(config.getUndefinedColor() == null){
            config.setUndefinedColor(WorldConfig.defaultConfig.getUndefinedColor());
        }
    }

    private void checkPlayerColor(){
        if(config.getPlayerColor() == null){
            config.setPlayerColor(WorldConfig.defaultConfig.getPlayerColor());
        }
    }
}

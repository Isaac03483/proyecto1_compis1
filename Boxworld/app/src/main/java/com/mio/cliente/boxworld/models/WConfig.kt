package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.builders.WConfigBuilder

class WConfig(val builderWConfigBuilder: WConfigBuilder) {

    val boxColor = builderWConfigBuilder.boxColor
    val boxOnTargetColor = builderWConfigBuilder.boxOnTargetColor
    val targetColor = builderWConfigBuilder.targetColor
    val brickColor = builderWConfigBuilder.brickColor
    val hallColor = builderWConfigBuilder.hallColor
    val undefinedColor = builderWConfigBuilder.undefinedColor
    val playerColor = builderWConfigBuilder.playerColor
}
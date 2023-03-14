package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.builders.WorldBuilder

data class World(val worldBuilder: WorldBuilder): Cloneable {

    val name: String = worldBuilder.name
    val rows: Int = worldBuilder.rows
    val cols: Int= worldBuilder.cols
    val config =worldBuilder.worldConfig
    val board = worldBuilder.boards
    val boxes= worldBuilder.boxes
    val targets = worldBuilder.targets
    val player = worldBuilder.player
}
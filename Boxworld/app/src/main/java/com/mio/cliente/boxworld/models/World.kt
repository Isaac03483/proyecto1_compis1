package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.builders.MatrixBuilder
import com.mio.cliente.boxworld.builders.WorldBuilder
import java.io.Serializable

data class World(val worldBuilder: WorldBuilder): Cloneable, Serializable {

    val name: String = worldBuilder.name
    val rows: Int = worldBuilder.rows
    val cols: Int= worldBuilder.cols
    val config =worldBuilder.worldConfig
    val board = worldBuilder.boards
    val boxes= worldBuilder.boxes
    val targets = worldBuilder.targets
    val player = worldBuilder.player

    val boardMatrix = MatrixBuilder().makeMatrix(this);
    override fun toString(): String {
        return "World(name='$name', rows=$rows, cols=$cols, config=$config, board=$board, boxes=$boxes, targets=$targets, player=$player)"
    }


}
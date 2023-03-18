package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.builders.BoardBuilder
import java.io.Serializable

data class Board(private val builder: BoardBuilder): Serializable {

    val point = builder.point
    val type: String = builder.type
    var hasBox: Boolean = false
    var hasTarget: Boolean = false
    var hasPlayer: Boolean = false


}
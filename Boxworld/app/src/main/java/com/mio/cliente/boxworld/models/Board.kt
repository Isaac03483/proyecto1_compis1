package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.builders.BoardBuilder

class Board(private val builder: BoardBuilder) {

    val point = builder.point
    val type: String = builder.type
}
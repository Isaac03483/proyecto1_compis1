package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.builders.PointBuilder

class Point(val pointBuilder: PointBuilder) {

    val posX = pointBuilder.posX
    val posY = pointBuilder.posY
}
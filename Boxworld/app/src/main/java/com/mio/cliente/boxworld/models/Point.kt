package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.builders.PointBuilder
import java.io.Serializable

data class Point(val pointBuilder: PointBuilder): Serializable {

    val posX = pointBuilder.posX
    val posY = pointBuilder.posY
}
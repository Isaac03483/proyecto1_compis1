package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.builders.PointBuilder
import java.io.Serializable

data class Point(val pointBuilder: PointBuilder): Serializable {

    var posX = pointBuilder.posX
    var posY = pointBuilder.posY
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (posX != other.posX) return false
        if (posY != other.posY) return false

        return true
    }

    override fun hashCode(): Int {
        var result = posX ?: 0
        result = 31 * result + (posY ?: 0)
        return result
    }

    override fun toString(): String {
        return "Point(posX=$posX, posY=$posY)"
    }


}
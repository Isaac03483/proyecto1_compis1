package com.mio.cliente.boxworld.models

import java.io.Serializable

class MovesCount(var left: Int = 0, var right: Int = 0, var up: Int = 0, var down: Int = 0): Serializable {

    fun addLeft(){
        left++
    }

    fun addRight(){
        right++
    }

    fun addUp(){
        up++
    }

    fun addDown(){
        down++
    }

}
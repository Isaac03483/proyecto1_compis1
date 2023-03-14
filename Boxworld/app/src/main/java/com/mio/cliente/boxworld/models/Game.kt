package com.mio.cliente.boxworld.models


class Game(val world: World) {

    private lateinit var worldCopy: World

    fun start(){
        worldCopy =world.copy()


    }

    fun restart(){
        worldCopy = world.copy()
    }

    fun createMatrix() {
    }
}
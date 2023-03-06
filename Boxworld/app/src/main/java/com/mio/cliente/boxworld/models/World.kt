package com.mio.cliente.boxworld.models

class World(val name: String,
            val rows: Int,
            val cols: Int,
            val config: WConfig,
            val board: ArrayList<Board>,
            val boxes: ArrayList<Point>,
            val targets: ArrayList<Point>,
            val player: Point) {
}
package com.mio.cliente.boxworld.models

data class Move( var push: Boolean = false, val direction: Int, val number: Double) {


    override fun toString(): String {
        return "Move(push=$push, direction=$direction, number=$number)"
    }
}
package com.mio.cliente.boxworld.models

open class Move(_push: Boolean, _direction: Int, _number: Int) {

    val direction = _direction
    val number = _number
    var push = _push

    override fun toString(): String {
        return "Move(direction=$direction, number=$number, push=$push)"
    }


}
package com.mio.cliente.boxworld.compiler.parser

import com.mio.cliente.boxworld.compiler.lexer.MovesLexer
import com.mio.cliente.boxworld.models.Move
import java.io.StringReader

class MovesParserHandle {

    fun compile(text: String){
        val compiler = MovesParser(MovesLexer(StringReader(text)))
        val moves = compiler.parse().value as ArrayList<*>
        moves.forEach {
            println("Movimiento: $it")
        }
        println("Esto debería aparecer en caso de no crashear xd")
    }
}
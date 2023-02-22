package com.mio.cliente.boxworld.compiler.parser

import com.mio.cliente.boxworld.compiler.lexer.MovesLexer
import java.io.StringReader

class MovesParserHandle {

    fun compile(text: String){
        val compiler = MovesParser(MovesLexer(StringReader(text)))
        compiler.parse()
        println("Esto debería aparecer en caso de no crashear xd")
    }
}
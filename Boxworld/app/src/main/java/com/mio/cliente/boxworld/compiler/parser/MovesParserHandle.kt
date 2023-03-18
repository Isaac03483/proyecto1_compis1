package com.mio.cliente.boxworld.compiler.parser

import com.mio.cliente.boxworld.compiler.Token
import com.mio.cliente.boxworld.compiler.lexer.MovesLexer
import com.mio.cliente.boxworld.models.Move
import com.mio.cliente.boxworld.models.MovesCount
import com.mio.cliente.boxworld.models.ParserError
import java.io.StringReader

class MovesParserHandle {

    var moves: ArrayList<Move>? = null
    var errors: ArrayList<ParserError>? = null
    var arithmeticToken: ArrayList<Token>?= null
    var movesToken: ArrayList<Token>?=null
    var movesCount: MovesCount? = null

    fun compile(text: String) {
        val lexer = MovesLexer(StringReader(text))
        val compiler = MovesParser(lexer)
        val sym = compiler.parse()

        if(sym != null && sym.value is ArrayList<*>){
            moves = sym.value as ArrayList<Move>
        }

        errors = compiler.errors as ArrayList<ParserError>
        arithmeticToken = lexer.arithmeticReport as ArrayList<Token>
        movesToken = lexer.movesTokens as ArrayList<Token>
        movesCount = lexer.count
    }
}
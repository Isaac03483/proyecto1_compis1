package com.mio.cliente.boxworld.compiler.parser

import com.mio.cliente.boxworld.compiler.lexer.XMLLexer
import com.mio.cliente.boxworld.models.Response
import java.io.StringReader

class XMLParserHandler {

    fun compile(text: String): Response {
        val lexer = XMLLexer(StringReader(text))
        val parser = XMLParser(lexer)

        return parser.parse().value as Response;
    }
}
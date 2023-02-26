package com.mio.server.compiler.parser;

import com.mio.server.compiler.lexer.XMLLexer;

import java.io.StringReader;

public class XMLParserHandle {

    public void compile(String text) throws Exception {
        XMLLexer lexer = new XMLLexer(new StringReader(text));
        XMLParser parser = new XMLParser(lexer);
        parser.parse();

    }
}

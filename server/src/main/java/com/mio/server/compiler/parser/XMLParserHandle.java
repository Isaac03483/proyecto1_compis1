package com.mio.server.compiler.parser;

import com.mio.server.compiler.lexer.XMLLexer;
import com.mio.server.models.World;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XMLParserHandle implements ParserHandle<List<World>> {


    @Override
    public List<World> compile(String text) throws Exception {
        XMLLexer lexer = new XMLLexer(new StringReader(text));
        XMLParser parser = new XMLParser(lexer);
//        parser.parse();
        return (ArrayList<World>) parser.parse().value;

    }
}

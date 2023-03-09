package com.mio.server.handlers;

import com.mio.server.compiler.lexer.XMLLexer;
import com.mio.server.compiler.parser.XMLParser;
import com.mio.server.models.World;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XMLParserHandler implements ParserHandler<List<World>> {


    @Override
    public List<World> compile(String text) throws Exception {
        XMLLexer lexer = new XMLLexer(new StringReader(text));
        XMLParser parser = new XMLParser(lexer);
//        parser.parse();
        return (ArrayList<World>) parser.parse().value;

    }
}

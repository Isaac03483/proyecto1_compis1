package com.mio.server.handlers;

import com.mio.server.compiler.lexer.XMLLexer;
import com.mio.server.compiler.parser.XMLParser;
import com.mio.server.models.WorldError;
import com.mio.server.models.World;
import com.mio.server.xmlMaker.FileMaker;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class XMLParserHandler implements ParserHandler<List<World>> {

    private List<World> worlds;
    private List<WorldError> errors;

    @Override
    public void compile(String text) throws Exception {
        XMLLexer lexer = new XMLLexer(new StringReader(text));
        XMLParser parser = new XMLParser(lexer);
//        parser.parse();
        worlds= (ArrayList<World>) parser.parse().value;
//        errors = parser.getErrors();

    }

    @Override
    public List<World> getValue() {
        return worlds;
    }

    @Override
    public List<WorldError> getErrors() {

        return errors;
    }
}

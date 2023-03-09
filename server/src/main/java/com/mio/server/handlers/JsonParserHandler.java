package com.mio.server.handlers;

import com.mio.server.compiler.lexer.JsonLexer;
import com.mio.server.compiler.parser.JsonParser;
import com.mio.server.models.Request;
import com.mio.server.models.World;

import java.io.StringReader;

public class JsonParserHandler implements ParserHandler<Request> {
    @Override
    public Request compile(String text) throws Exception {
        JsonLexer lexer = new JsonLexer(new StringReader(text));
        JsonParser parser = new JsonParser(lexer);
//        parser.parse();
        return (Request) parser.parse().value;

    }
}

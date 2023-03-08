package com.mio.server.compiler.parser;

import com.mio.server.compiler.lexer.JsonLexer;
import com.mio.server.models.World;

import java.io.StringReader;

public class JsonParserHandle implements ParserHandle<World>{
    @Override
    public World compile(String text) throws Exception {
        JsonLexer lexer = new JsonLexer(new StringReader(text));
        JsonParser parser = new JsonParser(lexer);
//        parser.parse();
        return (World) parser.parse().value;

    }
}

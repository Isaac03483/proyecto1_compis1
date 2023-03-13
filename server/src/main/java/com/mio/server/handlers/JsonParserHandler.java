package com.mio.server.handlers;

import com.mio.server.compiler.lexer.JsonLexer;
import com.mio.server.compiler.parser.JsonParser;
import com.mio.server.models.WorldError;
import com.mio.server.models.Request;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class JsonParserHandler implements ParserHandler<Request> {

    private Request request;
    private List<WorldError> errors;

    @Override
    public void compile(String text) throws Exception {
        JsonLexer lexer = new JsonLexer(new StringReader(text));
        errors =new ArrayList<>();
        JsonParser parser = new JsonParser(lexer);
//        parser.parse();
        request = (Request) parser.parse().value;
        errors = parser.getErrors();
    }

    @Override
    public Request getValue() {
        return request;
    }

    @Override
    public List<WorldError> getErrors() {
        return errors;
    }

}

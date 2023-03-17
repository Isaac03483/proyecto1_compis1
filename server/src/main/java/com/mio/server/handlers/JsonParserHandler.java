package com.mio.server.handlers;

import com.mio.server.compiler.Token;
import com.mio.server.compiler.lexer.JsonLexer;
import com.mio.server.compiler.parser.JsonParser;
import com.mio.server.models.WorldError;
import com.mio.server.models.Request;
import java_cup.runtime.Symbol;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class JsonParserHandler implements ParserHandler<Request> {

    private Request request;
    private List<WorldError> errors;
    private List<Token> arithmeticReport;

    @Override
    public void compile(String text) throws Exception {
        JsonLexer lexer = new JsonLexer(new StringReader(text));
        errors =new ArrayList<>();
        JsonParser parser = new JsonParser(lexer);
//        parser.parse();
        Symbol sym = parser.parse();

        if(sym != null && sym.value instanceof Request){
            request =(Request) sym.value;
        }

        errors = parser.getErrors();
        arithmeticReport = lexer.getArithmeticReport();
    }

    @Override
    public Request getValue() {
        return request;
    }

    @Override
    public List<WorldError> getErrors() {
        return errors;
    }

    public List<Token> getReport() {
        return arithmeticReport;
    }
}

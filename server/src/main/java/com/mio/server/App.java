package com.mio.server;

import com.mio.server.lexer.JsonLexer;
import com.mio.server.symbols.Token;
import com.mio.server.symbols.TokenSym;

import java.io.IOException;
import java.io.StringReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        String texto = "{ ] } ; \" name   \" : \" _aw1    \" \" 3 + 4 * 6 \" 32 [ ] \" all \n\n\"   \" #fff2221\"";

        JsonLexer lexer = new JsonLexer(new StringReader(texto));

        try {
            Token token = lexer.yylex();

            while(token.getType() != TokenSym.EOF){
                token = lexer.yylex();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

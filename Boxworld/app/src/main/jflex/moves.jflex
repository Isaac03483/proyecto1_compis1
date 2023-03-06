package com.mio.cliente.boxworld;

import com.mio.cliente.boxworld.compiler.Token;
import java_cup.runtime.Symbol;
import static com.mio.cliente.boxworld.compiler.parser.MovesParserSym.*;


/*
compilar archivo.jflex
java -jar jflex-full-1.9.0.jar /home/mio/Escritorio/2023/proyecto-1-compis1/Boxworld/app/src/main/jflex/moves.jflex
*/

%%
%public
%class MovesLexer
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup

%state BLOQUE_COMENTARIO


%{
    private Symbol symbolWithValue(int type, Object value){
        return new Symbol(type, new Token(type, value.toString(), yyline+1, yycolumn+1 ));
    }

    private Symbol symbolWithoutValue(int type){
        return new Symbol(type, new Token(type, null, yyline+1, yycolumn+1 ));
    }
%}

/*
%{
    private Token symbolWithValue(int type, Object value){
        Token token = new Token(type, value.toString(), yyline+1, yycolumn+1 );
        System.out.println(token);
        return token;
    }

    private Token symbolWithoutValue(int type){
        Token token = new Token(type, null, yyline+1, yycolumn+1 );
        System.out.println(token);
        return token;
    }
%}
*/

%eofval{
    return symbolWithoutValue(EOF);
%eofval}
%eofclose

SALTO_LINEA = \r|\n|\r\n
ESPACIO_BLANCO = {SALTO_LINEA}|[ \t\f]
UP = "up"
DOWN = "down"
LEFT = "left"
RIGHT = "right"
PUSH = "push"
INICIO_COMENTARIO = "#"
PUNTO_COMA = ";"
PARENTESIS_A = "("
PARENTESIS_C = ")"
SUMA = "+"
RESTA = "-"
MULTIPLICACION = "*"
DIVISION = "/"
FLOOR = "FLOOR"
CEIL = "CEIL"
ENTERO = 0 | [1-9][0-9]*
DECIMAL = {ENTERO} \. [0-9]+

%%

<YYINITIAL>{

    {ESPACIO_BLANCO}                {;}

    {INICIO_COMENTARIO}
    {
        System.out.println("Encontré un comentario");
        yybegin(BLOQUE_COMENTARIO);
    }

    {UP}
    {
        return symbolWithoutValue(UP);
    }

    {DOWN}
    {
        return symbolWithoutValue(DOWN);
    }

    {LEFT}
    {
        return symbolWithoutValue(LEFT);
    }

    {RIGHT}
    {
        return symbolWithoutValue(RIGHT);
    }

    {PUSH}
    {
        return symbolWithoutValue(PUSH);
    }

    {SUMA}
    {
        return symbolWithoutValue(SUMA);
    }

    {RESTA}
    {
        return symbolWithoutValue(RESTA);
    }

    {MULTIPLICACION}
    {
        return symbolWithoutValue(MULTIPLICACION);
    }

    {DIVISION}
    {
        return symbolWithoutValue(DIVISION);
    }

    {FLOOR}
    {
        return symbolWithoutValue(FLOOR);
    }

    {CEIL}
    {
        return symbolWithoutValue(CEIL);
    }

    {PARENTESIS_A}
    {
        return symbolWithoutValue(PARENTESIS_A);
    }

    {PARENTESIS_C}
    {
        return symbolWithoutValue(PARENTESIS_C);
    }

    {PUNTO_COMA}
    {
        return symbolWithoutValue(PUNTO_COMA);
    }

    {ENTERO}
    {
        return symbolWithValue(ENTERO, yytext());
    }

    {DECIMAL}
    {
        return symbolWithValue(DECIMAL, yytext());
    }


}

<BLOQUE_COMENTARIO>{
    "\n"                    {yybegin(YYINITIAL);}

    [^]                     {;}
}

[^]
{
    System.out.println("Error: <" + yytext() + ">");
}



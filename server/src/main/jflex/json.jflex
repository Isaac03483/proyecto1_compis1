package com.mio.server.compiler.lexer;

/*
compilar archivo.jflex
java -jar jflex-full-1.9.0.jar /home/mio/Escritorio/2023/proyecto-1-compis1/server/src/main/jflex/json.jflex
*/

import com.mio.server.compiler.Token;
import static com.mio.server.compiler.parser.JsonParserSym.*;
import java_cup.runtime.Symbol;



%%

%public
%class JsonLexer
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup

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
%}*/

%eofval{
    return symbolWithoutValue(EOF);
%eofval}
%eofclose

SALTO_LINEA = \r|\n|\r\n
ESPACIO_BLANCO = {SALTO_LINEA}|[ \t\f]
COMILLA = \"
NAME = "name"
ROWS = "rows"
FLOOR = "FLOOR"
CEIL = "CEIL"
SUMA = "+"
RESTA = "-"
MULTIPLICACION = "*"
DIVISION = "/"
PARENTESIS_A = "("
PARENTESIS_C = ")"
DOS_PUNTOS = ":"
COMA = ","
LLAVE_A = "{"
LLAVE_C = "}"
CORCHETE_A = "["
CORCHETE_C = "]"
COLS = "cols"
CONFIG = "config"
BOX_COLOR = "box_color"
BOX_ON_TARGET_COLOR = "box_on_target_color"
TARGET_COLOR = "target_color"
BRICK_COLOR = "brick_color"
HALL_COLOR = "hall_color"
UNDEFINED_COLOR = "undefined_color"
PLAYER_COLOR = "player_color"
BOARD = "board"
POS_X = "posX"
POS_Y = "posY"
TYPE = "type"
BRICK = "BRICK"
HALL = "HALL"
BOXES = "boxes"
TARGETS = "targets"
PLAYER = "player"
WORLDS = "worlds"
WORLD = "world"
ALL = "all"
HEXADECIMAL = "#"[a-f0-9]{6}
ENTERO = 0 | [1-9][0-9]*
PALABRA = [a-zA-Z_][a-zA-z][a-zA-z0-9]*
DECIMAL = {ENTERO} \. [0-9]+

%%

<YYINITIAL>{
    {ESPACIO_BLANCO}                {;}

    {DOS_PUNTOS}
    {
        return symbolWithoutValue(DOS_PUNTOS);
    }

    {COMA}
    {
        return symbolWithoutValue(COMA);
    }

    {LLAVE_A}
    {
        return symbolWithoutValue(LLAVE_A);
    }

    {LLAVE_C}
    {
        return symbolWithoutValue(LLAVE_C);
    }

    {CORCHETE_A}
    {
        return symbolWithoutValue(CORCHETE_A);
    }

    {CORCHETE_C}
    {
        return symbolWithoutValue(CORCHETE_C);
    }

    {ENTERO}
    {
        return symbolWithValue(ENTERO, yytext());
    }

    {DECIMAL}
    {
        return symbolWithValue(DECIMAL, yytext());
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

    {COMILLA}
    {
        return symbolWithoutValue(COMILLA);
    }

    {NAME}
    {
        return symbolWithoutValue(NAME);
    }

    {ROWS}
    {
        return symbolWithoutValue(ROWS);
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

    {COLS}
    {
        return symbolWithoutValue(COLS);

    }

    {CONFIG}
    {
        return symbolWithoutValue(CONFIG);

    }

    {BOX_COLOR}
    {
        return symbolWithoutValue(BOX_COLOR);

    }

    {BOX_ON_TARGET_COLOR}
    {
        return symbolWithoutValue(BOX_ON_TARGET_COLOR);

    }

    {TARGET_COLOR}
    {
        return symbolWithoutValue(TARGET_COLOR);

    }

    {BRICK_COLOR}
    {
        return symbolWithoutValue(BRICK_COLOR);

    }

    {HALL_COLOR}
    {
        return symbolWithoutValue(HALL_COLOR);

    }

    {UNDEFINED_COLOR}
    {
        return symbolWithoutValue(UNDEFINED_COLOR);

    }

    {PLAYER_COLOR}
    {
        return symbolWithoutValue(PLAYER_COLOR);

    }

    {HEXADECIMAL}
    {
        return symbolWithValue(HEXADECIMAL, yytext());

    }

    {BOARD}
    {
        return symbolWithoutValue(BOARD);

    }

    {POS_X}
    {
        return symbolWithoutValue(POSX);

    }

    {POS_Y}
    {
        return symbolWithoutValue(POSY);

    }

    {TYPE}
    {
        return symbolWithoutValue(TYPE);

    }

    {BRICK}
    {
        return symbolWithoutValue(BRICK);

    }

    {HALL}
    {
        return symbolWithoutValue(HALL);

    }

    {BOXES}
    {
        return symbolWithoutValue(BOXES);

    }

    {TARGETS}
    {
        return symbolWithoutValue(TARGETS);

    }

    {PLAYER}
    {
        return symbolWithoutValue(PLAYER);
    }

    {WORLDS}
    {
        return symbolWithoutValue(WORLDS);

    }

    {WORLD}
    {
        return symbolWithoutValue(WORLD);

    }

    {ALL}
    {
        return symbolWithoutValue(ALL);
    }

    {PALABRA}
    {
        return symbolWithValue(PALABRA, yytext());
    }

}

[^]
{
    System.out.println("Error: <" + yytext() + ">");
}


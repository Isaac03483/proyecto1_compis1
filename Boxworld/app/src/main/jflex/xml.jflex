package com.mio.cliente.boxworld.compiler.lexer;

import com.mio.cliente.boxworld.compiler.Token;
import static com.mio.cliente.boxworld.compiler.XMLSym.*;

/*
compilar archivo.jflex
java -jar jflex-full-1.9.0.jar /home/mio/Escritorio/2023/proyecto-1-compis1/Boxworld/app/src/main/jflex/xml.jflex
*/

%%

%public
%class XMLLexer
%unicode
%line
%column
%type Token//java_cup_runtime.Symbol
//%cup

%state INICIO_ETIQUETA
%state FIN_ETIQUETA

/*
%{
    private Symbol symbolWithValue(int type, Object value){
        return new Symbol(type, new Token(type, value.toString(), yyline+1, yycolumn+1 ));
    }

    private Symbol symbolWithoutValue(int type){
        return new Symbol(type, new Token(type, null, yyline+1, yycolumn+1 ));
    }
%}
*/

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

%eofval{
    return symbolWithoutValue(EOF);
%eofval}
%eofclose

SALTO_LINEA = \r|\n|\r\n
ESPACIO_BLANCO = {SALTO_LINEA}|[ \t\f]
CONTRA_DIAGONAL = "/"
MENOR_QUE = "<"
MAYOR_QUE = ">"
WORLDS = "worlds"
WORLD = "world"
NAME = "name"
ROWS = "rows"
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
ERROR = "error"
ERRORS = "errors"
LEXEMA = "lexema"
LINE = "line"
COLUMN = "column"
TYPE = "type"
DESCRIPTION = "description"
HEXADECIMAL = "#"[a-f0-9]{6}
ENTERO = 0 | [1-9][0-9]*
PALABRA = [a-zA-Z_][a-zA-z][a-zA-z0-9]*

%%

<YYINITIAL>{

}


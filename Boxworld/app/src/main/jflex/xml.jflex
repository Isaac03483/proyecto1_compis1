package com.mio.cliente.boxworld.compiler.lexer;

import static com.mio.cliente.boxworld.compiler.parser.XMLParserSym.*;
import com.mio.cliente.boxworld.compiler.Token;
import java_cup.runtime.Symbol;

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
%type java_cup.runtime.Symbol
%cup

%state ESTADO_COMILLAS
%state ESTADO_MENSAJE

%{
    private Symbol symbolWithValue(int type, Object value){
        System.out.println("ENCONTRE UN : "+value.toString());
        return new Symbol(type, new Token(type, value.toString(), yyline+1, yycolumn+1 ));
    }

    private Symbol symbolWithoutValue(int type){
        System.out.println("ENCONTRE UN : "+type);
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
DESCRIPTION = "description"
HEXADECIMAL = "#"[a-f0-9]{6}
ENTERO = 0 | [1-9][0-9]*
PALABRA = [a-zA-Z_][a-zA-z][a-zA-z0-9]*
LITERAL = {PALABRA}\-({ENTERO}|{DECIMAL})|{ENTERO}| {DECIMAL}

%%

<YYINITIAL>{
    {ESPACIO_BLANCO}                    {;}
    {COMILLA}                           {yybegin(ESTADO_COMILLAS);}
    {WORLDS}                            {return symbolWithoutValue(WORLDS);}
    {ERRORS}                            {return symbolWithoytValue(ERRORS);}
    {LEXEMA}                            {return symbolWithoytValue(ERROR);}
    {LINE}                              {return symbolWithoytValue(LINE);}
    {COLUMN}                            {return symbolWithoytValue(COLUMN);}
    {DESCRIPTION}                       {return symbolWithoytValue(DESCRIPTION);}
    {IGUAL}                             {return symbolWithoutValue(IGUAL);}
    {INTERROGACION}                     {return symbolWithoutValue(INTERROGACION);}
    {ENCODING}                          {return symbolWithoutValue(ENCODING);}
    {XML}                               {return symbolWithoutValue(XML);}
    {VERSION}                           {return symbolWithoutValue(VERSION);}
    {WORLD}                             {return symbolWithoutValue(WORLD);}
    {NAME}                              {return symbolWithoutValue(NAME);}
    {ROWS}                              {return symbolWithoutValue(ROWS);}
    {COLS}                              {return symbolWithoutValue(COLS);}
    {CONFIG}                            {return symbolWithoutValue(CONFIG);}
    {BOX_COLOR}                         {return symbolWithoutValue(BOX_COLOR);}
    {BOX_ON_TARGET_COLOR}               {return symbolWithoutValue(BOX_ON_TARGET_COLOR);}
    {TARGET_COLOR}                      {return symbolWithoutValue(TARGET_COLOR);}
    {BRICK_COLOR}                       {return symbolWithoutValue(BRICK_COLOR);}
    {HALL_COLOR}                        {return symbolWithoutValue(HALL_COLOR);}
    {UNDEFINED_COLOR}                   {return symbolWithoutValue(UNDEFINED_COLOR);}
    {PLAYER_COLOR}                      {return symbolWithoutValue(PLAYER_COLOR);}
    {BOARD}                             {return symbolWithoutValue(BOARD);}
    {POS_X}                             {return symbolWithoutValue(POSX);}
    {POS_Y}                             {return symbolWithoutValue(POSY);}
    {TYPE}                              {return symbolWithoutValue(TYPE);}
    {BRICK}                             {return symbolWithoutValue(BRICK);}
    {HALL}                              {return symbolWithoutValue(HALL);}
    {BOXES}                             {return symbolWithoutValue(BOXES);}
    {TARGETS}                           {return symbolWithoutValue(TARGETS);}
    {PLAYER}                            {return symbolWithoutValue(PLAYER);}
    {DIAGONAL}                          {return symbolWithoutValue(DIAGONAL);}
    {MAYOR_QUE}                         {return symbolWithoutValue(MAYOR_QUE);}
    {MENOR_QUE}                         {return symbolWithoutValue(MENOR_QUE);}
    {ENTERO}                            {return symbolWithValue(ENTERO, yytext());}
    {HEXADECIMAL}                       {return symbolWithValue(HEXADECIMAL, yytext());}
    {PALABRA}                           {return symbolWithValue(PALABRA, yytext());}
}

<ESTADO_COMILLAS>{
    {ESPACIO_BLANCO}        {;}
    {COMILLA}               {yybegin(YYINITIAL);}
    {LITERAL}               {return symbolWithValue(LITERAL, yytext());}

}

[^]
{
    System.out.println("Error: <" + yytext() + ">");
}

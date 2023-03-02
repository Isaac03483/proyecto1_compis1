package com.mio.cliente.boxworld.compiler.lexer;

import static com.mio.server.compiler.parser.XMLTestParserSym.*;
import com.mio.server.compiler.Token;
import java_cup.runtime.Symbol;

/*
compilar archivo.jflex
java -jar jflex-full-1.9.0.jar /home/mio/Escritorio/2023/proyecto-1-compis1/Boxworld/app/src/main/jflex/xml.jflex
*/

%%

%public
%class XMLTestLexer
%unicode
%line
%column
%type java_cup.runtime.Symbol
%cup

%state ESTADO_COMILLAS
%state APERTURA
%state CIERRE
%state HEADER


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
DIAGONAL = "/"
MENOR_QUE = "<"
MAYOR_QUE = ">"
COMILLA = \"
INTERROGACION = "?"
IGUAL = "="
ENCODING = "encoding"
XML = "xml"
VERSION = "version"

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
HEXADECIMAL = "#"[a-f0-9]{6}
ENTERO = 0 | [1-9][0-9]*
DECIMAL = {ENTERO}\.\d+
PALABRA = [a-zA-Z_][a-zA-z][a-zA-z0-9]*
LITERAL = {PALABRA}\-({ENTERO}|{DECIMAL})|{ENTERO}| {DECIMAL}

%%

<YYINITIAL>{

    {ESPACIO_BLANCO}                    {;}
    {MENOR_QUE}                         {yybegin(APERTURA);}
    {ENTERO}                            {return symbolWithValue(ENTERO, yytext());}
    {HEXADECIMAL}                       {return symbolWithValue(HEXADECIMAL, yytext());}
    {BRICK}                             {return symbolWithoutValue(BRICK);}
    {HALL}                              {return symbolWithoutValue(HALL);}
    {PALABRA}                           {return symbolWithValue(PALABRA, yytext());}
}

<ESTADO_COMILLAS>{
    {ESPACIO_BLANCO}        {;}
    {COMILLA}               {yybegin(HEADER);}
    {LITERAL}               {return symbolWithValue(LITERAL, yytext());}

}

<APERTURA>{
    {ESPACIO_BLANCO}                    {;}
    {INTERROGACION}                     {yybegin(HEADER);
                                        return symbolWithoutValue(INTERROGACION);}
    {DIAGONAL}                          {yybegin(CIERRE);}
    {MAYOR_QUE}                         {yybegin(YYINITIAL);}
    {WORLDS}                            {return symbolWithoutValue(WORLDS_A);}
    {WORLD}                             {return symbolWithoutValue(WORLD_A);}
    {NAME}                              {return symbolWithoutValue(NAME_A);}
    {ROWS}                              {return symbolWithoutValue(ROWS_A);}
    {COLS}                              {return symbolWithoutValue(COLS_A);}
    {CONFIG}                            {return symbolWithoutValue(CONFIG_A);}
    {BOX_COLOR}                         {return symbolWithoutValue(BOX_COLOR_A);}
    {BOX_ON_TARGET_COLOR}               {return symbolWithoutValue(BOX_ON_TARGET_COLOR_A);}
    {TARGET_COLOR}                      {return symbolWithoutValue(TARGET_COLOR_A);}
    {BRICK_COLOR}                       {return symbolWithoutValue(BRICK_COLOR_A);}
    {HALL_COLOR}                        {return symbolWithoutValue(HALL_COLOR_A);}
    {UNDEFINED_COLOR}                   {return symbolWithoutValue(UNDEFINED_COLOR_A);}
    {PLAYER_COLOR}                      {return symbolWithoutValue(PLAYER_COLOR_A);}
    {BOARD}                             {return symbolWithoutValue(BOARD_A);}
    {POS_X}                             {return symbolWithoutValue(POSX_A);}
    {POS_Y}                             {return symbolWithoutValue(POSY_A);}
    {TYPE}                              {return symbolWithoutValue(TYPE_A);}
    {BOXES}                             {return symbolWithoutValue(BOXES_A);}
    {TARGETS}                           {return symbolWithoutValue(TARGETS_A);}
    {PLAYER}                            {return symbolWithoutValue(PLAYER_A);}
}

<CIERRE>{
    {ESPACIO_BLANCO}                    {;}
    {MAYOR_QUE}                         {yybegin(YYINITIAL);}
    {WORLDS}                            {return symbolWithoutValue(WORLDS_C);}
    {WORLD}                             {return symbolWithoutValue(WORLD_C);}
    {NAME}                              {return symbolWithoutValue(NAME_C);}
    {ROWS}                              {return symbolWithoutValue(ROWS_C);}
    {COLS}                              {return symbolWithoutValue(COLS_C);}
    {CONFIG}                            {return symbolWithoutValue(CONFIG_C);}
    {BOX_COLOR}                         {return symbolWithoutValue(BOX_COLOR_C);}
    {BOX_ON_TARGET_COLOR}               {return symbolWithoutValue(BOX_ON_TARGET_COLOR_C);}
    {TARGET_COLOR}                      {return symbolWithoutValue(TARGET_COLOR_C);}
    {BRICK_COLOR}                       {return symbolWithoutValue(BRICK_COLOR_C);}
    {HALL_COLOR}                        {return symbolWithoutValue(HALL_COLOR_C);}
    {UNDEFINED_COLOR}                   {return symbolWithoutValue(UNDEFINED_COLOR_C);}
    {PLAYER_COLOR}                      {return symbolWithoutValue(PLAYER_COLOR_C);}
    {BOARD}                             {return symbolWithoutValue(BOARD_C);}
    {POS_X}                             {return symbolWithoutValue(POSX_C);}
    {POS_Y}                             {return symbolWithoutValue(POSY_C);}
    {TYPE}                              {return symbolWithoutValue(TYPE_C);}
    {BOXES}                             {return symbolWithoutValue(BOXES_C);}
    {TARGETS}                           {return symbolWithoutValue(TARGETS_C);}
    {PLAYER}                            {return symbolWithoutValue(PLAYER_C);}
}

<HEADER>{
    {ESPACIO_BLANCO}                    {;}
    {INTERROGACION}                     {return symbolWithoutValue(INTERROGACION);}
    {COMILLA}                           {yybegin(ESTADO_COMILLAS);}
    {IGUAL}                             {return symbolWithoutValue(IGUAL);}
    {ENCODING}                          {return symbolWithoutValue(ENCODING);}
    {XML}                               {return symbolWithoutValue(XML);}
    {VERSION}                           {return symbolWithoutValue(VERSION);}
    {MAYOR_QUE}                         {yybegin(YYINITIAL);}

}

[^]
{
    System.out.println("Error: <" + yytext() + ">");
}


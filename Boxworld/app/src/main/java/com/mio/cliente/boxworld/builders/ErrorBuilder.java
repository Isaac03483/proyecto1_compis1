package com.mio.cliente.boxworld.builders;

import com.mio.cliente.boxworld.models.ErrorType;
import com.mio.cliente.boxworld.models.WorldError;

public class ErrorBuilder {

    private String lexema;
    private Integer line;
    private Integer column;
    private ErrorType errorType;
    private String description;

    public ErrorBuilder() {
    }

    public ErrorBuilder withLexema(String lexema){
        this.lexema = lexema;
        return this;
    }

    public ErrorBuilder withLine(Integer line){
        this.line = line;
        return this;
    }

    public ErrorBuilder withColumn(Integer column){
        this.column = column;
        return this;
    }

    public ErrorBuilder withErrorType(ErrorType errorType){
        this. errorType = errorType;
        return this;
    }

    public ErrorBuilder withDescription(String description){
        this.description = description;
        return this;
    }

    public WorldError build(){
        return new WorldError(this);
    }

    public void clean(){
        this.lexema = null;
        this.line =null;
        this.column = null;
        this.errorType = null;
        this.description = null;
    }

    public String getLexema() {
        return lexema;
    }

    public Integer getLine() {
        return line;
    }

    public Integer getColumn() {
        return column;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public String getDescription() {
        return description;
    }
}

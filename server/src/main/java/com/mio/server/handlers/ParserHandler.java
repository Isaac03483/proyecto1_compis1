package com.mio.server.handlers;

import com.mio.server.models.WorldError;

import java.util.List;

public interface ParserHandler<T> {

    void compile(String text) throws Exception;

    T getValue();

    List<WorldError> getErrors();
}

package com.mio.server.handlers;

public interface ParserHandler<T> {

    T compile(String text) throws Exception;
}

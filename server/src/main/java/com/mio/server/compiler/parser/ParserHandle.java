package com.mio.server.compiler.parser;

import java.util.List;

public interface ParserHandle<T> {

    T compile(String text) throws Exception;
}

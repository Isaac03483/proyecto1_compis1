package com.mio.server.models;


public record Error(String value, int line, int column,ErrorType errorType,String description) {
}

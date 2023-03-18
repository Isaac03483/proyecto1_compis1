package com.mio.server.models;

public record WorldError(String value, int line, int column, ErrorType errorType, String description) {

    @Override
    public String toString() {
        return "WorldError{" +
                "value='" + value + '\'' +
                ", line=" + line +
                ", column=" + column +
                ", errorType=" + errorType +
                ", description='" + description + '\'' +
                '}';
    }
}

package com.mio.server;

import com.mio.server.compiler.parser.XMLParserHandle;

import java.awt.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        String texto = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<worlds>" +
                "<world>" +
                "<name>ak3</name>" +
                "</world>" +
                "</worlds>";
        XMLParserHandle parserHandle = new XMLParserHandle();
        try {
            parserHandle.compile(texto);
            System.out.println("Esto debería aparecer en caso de no crashear");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

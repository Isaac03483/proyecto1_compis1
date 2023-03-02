package com.mio.server;

import com.mio.server.compiler.parser.XMLParserHandle;
import com.mio.server.views.ServerView;

import java.awt.*;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
        ServerView serverView = new ServerView();
        serverView.setVisible(true);
    }
}

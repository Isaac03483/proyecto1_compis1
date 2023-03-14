package com.mio.server;

import com.mio.server.handlers.JsonParserHandler;
import com.mio.server.views.ServerView;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception {

        ServerView serverView = new ServerView();
        serverView.setVisible(true);
    }


}

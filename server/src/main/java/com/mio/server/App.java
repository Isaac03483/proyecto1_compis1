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
/*
        JsonParserHandler jsonParserHandler = new JsonParserHandler();
        try{
            jsonParserHandler.compile("{\n" +
                    "  \"player~#\": {\n" +
                    "    \"posX\": 1&%$,\n" +
                    "    \"posY\": \"(5 + 2) / (3 + 4)\"\n" +
                    "  },\n" +
                    "  \"rows\": 4,\n" +
                    "  \"name\": \"nombrePrueba\",\n" +
                    "  \"cols\": 4,\n" +
                    "  \"config\": {\n" +
                    "    \"box_color\": \"#ffff00\",\n" +
                    "    \"box_on_target_color\": \"#fe0002\",\n" +
                    "    \"target_color\": \"#d6fe0a\",\n" +
                    "    \"brick_color\": \"#bdbebf\",\n" +
                    "    \"hall_color\": \"#0001ff\",\n" +
                    "    \"undefined_color\": \"#303030\",\n" +
                    "    \"player_color\": \"#ff00f7\"\n" +
                    "  },\n" +
                    "  \"cols\": 4,\n" +
                    "  \"config\": {\n" +
                    "    \"box_color\": \"#ffff00\",\n" +
                    "    \"box_on_target_color\": \"#fe0002\",\n" +
                    "    \"target_color\": \"#d6fe0a\",\n" +
                    "    \"brick_color\": \"#bdbebf\",\n" +
                    "    \"hall_color\": \"#0001ff\",\n" +
                    "    \"undefined_color\": \"#303030\",\n" +
                    "    \"player_color\": \"#ff00f7\"\n" +
                    "  },\n" +
                    "  \"board\": [\n" +
                    "    {\n" +
                    "      \"posX\": 0,\n" +
                    "      \"posY\": \"2 * 1\",\n" +
                    "      \"type\": \"BRICK\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"posX\": 0,\n" +
                    "      \"posY\": \"9 / 3 * 1\",\n" +
                    "      \"type\": \"BRICK\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"posX\": 0,\n" +
                    "      \"posY\": \"10 / 2 - 1\",\n" +
                    "      \"type\": \"BRICK\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"posX\": \"2 / 2\",\n" +
                    "      \"posY\": 0,\n" +
                    "      \"type\": \"BRICK\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"posX\": \"10 - 3 * 3\",\n" +
                    "      \"posY\": \"3 * 2 - 5\",\n" +
                    "      \"type\": \"HALL\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"posX\": 1,\n" +
                    "      \"posY\": \"2 * 1\",\n" +
                    "      \"type\": \"HALL\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"boxes\": [\n" +
                    "    {\n" +
                    "      \"posX\": 2,\n" +
                    "      \"posY\": 1\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"posX\": 2,\n" +
                    "      \"posY\": \"1 + 1\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"targets\": [\n" +
                    "    {\n" +
                    "      \"posX\": \"4 / 2 + 1\",\n" +
                    "      \"posY\": 1\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"posX\": \"4 / 2 + 1\",\n" +
                    "      \"posY\": \"1 * 1 + 1\"\n" +
                    "    }\n" +
                    "  ],\n" +
                    "  \"player\": {\n" +
                    "    \"posX\": 1,\n" +
                    "    \"posY\": \"5 + 2) / (3 + 4)\"\n" +
                    "  }\n" +
                    "}");

        }catch (Exception e){

            System.err.println("Something went wrong");
        }
//        System.out.println("jsonParserHandler = " + jsonParserHandler.getValue());
        jsonParserHandler.getErrors().forEach(System.out::println);*/
    }


}

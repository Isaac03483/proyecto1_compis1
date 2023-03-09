package com.mio.server.handlers;

import com.mio.server.models.Request;
import com.mio.server.models.Response;

public class RequestHandler {


    public Response jsonParse(String json){

        try {
            Request request = new JsonParserHandler().compile(json);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return null;
    }
}

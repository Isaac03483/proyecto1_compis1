package com.mio.server.xmlMaker;

import com.mio.server.models.World;

import java.util.List;

public class XMLMaker {

    private static XMLMaker maker;
    private XMLMaker(){

    }

    public static XMLMaker getInstance(){
        if(maker == null){
            maker = new XMLMaker();
        }
        return maker;
    }

    public void jsonToXML(List<World> worlds){

    }
}

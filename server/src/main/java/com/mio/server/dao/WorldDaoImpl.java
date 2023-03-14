package com.mio.server.dao;

import com.mio.server.exceptions.DuplicateWorldException;
import com.mio.server.handlers.XMLParserHandler;
import com.mio.server.models.World;
import com.mio.server.xmlMaker.FileMaker;
import com.mio.server.xmlMaker.XMLMaker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WorldDaoImpl implements WorldDAO{

    @Override
    public World create(World world) throws IOException {
        World worldSearched = findByName(world.getName());

        if(worldSearched != null){
            throw new DuplicateWorldException("Ya existe un mundo con dicho nombre");
        }

        List<World> worlds = findAll();

        worlds.add(world);
        FileMaker.getInstance().write(XMLMaker.getInstance().worldsToXML(worlds));
        return world;
    }

    @Override
    public List<World> findAll() {

        List<World> worlds = new ArrayList<>();
        try {
            String xmlContent = FileMaker.getInstance().read();

            if(xmlContent.equals("")){
                return worlds;
            }

            XMLParserHandler xmlParserHandler=  new XMLParserHandler();
            xmlParserHandler.compile(xmlContent);

            worlds = xmlParserHandler.getValue();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return worlds;
    }

    @Override
    public World findByName(String name) {
        List<World> worlds = findAll();

        if(worlds.isEmpty()){
            return null;
        }

        return worlds.stream().filter(world1 -> world1.getName().equals(name)).findFirst().orElse(null);
    }
}

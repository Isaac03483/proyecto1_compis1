package com.mio.server.dao;

import com.mio.server.models.World;

import java.io.IOException;
import java.util.List;

public interface WorldDAO {


    World create(World world) throws IOException;

    List<World> findAll();

    World findByName(String name);


}

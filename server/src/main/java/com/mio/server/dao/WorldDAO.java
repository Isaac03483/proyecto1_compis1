package com.mio.server.dao;

import com.mio.server.models.World;

public interface WorldDAO {


    String create(World world);

    String findAll();

    String findByName(String name);


}

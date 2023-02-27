package com.mio.server.builders;

import com.mio.server.models.Board;
import com.mio.server.models.Point;
import com.mio.server.models.World;
import com.mio.server.models.WorldConfig;

import java.util.List;

public class WorldBuilder {

    private String name;
    private Integer rows;
    private Integer cols;
    private WorldConfig worldConfig;
    private List<Board> boards;
    private List<Point> boxes;
    private List<Point> targets;
    private Point player;

    public WorldBuilder() {
    }

    public WorldBuilder withName(String name){
        if(this.name != null){
            throw new RuntimeException("el nombre del mundo ya ha sido declarado");
        }
        this.name = name;
        return this;
    }

    public WorldBuilder withRows(Integer rows){
        if(this.rows != null){
            throw new RuntimeException("El número de filas ya ha sido declarado.");
        }
        this.rows = rows;
        return this;
    }

    public WorldBuilder withCols(Integer cols){
        if(this.cols != null){
            throw new RuntimeException("El número de filas ya ha sido declarado.");
        }
        this.cols = cols;
        return this;
    }

    public WorldBuilder withConfig(WorldConfig config){
        if(this.worldConfig != null){
            throw new RuntimeException("Las configuraciones ya han sido declaradas");
        }
        this.worldConfig = config;
        return this;
    }

    public WorldBuilder withBoards(List<Board> board){
        if(this.boards != null){
            throw new RuntimeException("La lista del tablero ya ha sido declarada");

        }
        this.boards = board;
        return this;
    }

    public WorldBuilder withBoxes(List<Point> boxes){
        if(this.boxes != null){
            throw new RuntimeException("La lista de cajas ya ha sido declarada");

        }
        this.boxes = boxes;
        return this;
    }

    public WorldBuilder withTargets(List<Point> targets){
        if(this.targets != null){
            throw new RuntimeException("La lista de objetivos ya ha sido declarada");

        }
        this.targets = targets;
        return this;
    }

    public WorldBuilder withPlayer(Point player){
        if(this.player != null){
            throw new RuntimeException("La posición del jugador ya ha sido declarada");
        }
        this.player = player;
        return this;
    }

    public World build(){
        return new World(this);
    }

    public String getName() {
        return name;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getCols() {
        return cols;
    }

    public WorldConfig getWorldConfig() {
        return worldConfig;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public List<Point> getBoxes() {
        return boxes;
    }

    public List<Point> getTargets() {
        return targets;
    }

    public Point getPlayer() {
        return player;
    }

    public void clean(){
        this.name = null;
        this. rows = null;
        this.cols = null;
        this.worldConfig = null;
        this.boards = null;
        this.boxes = null;
        this.targets = null;
        this.player = null;
    }
}

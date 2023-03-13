package com.mio.server.builders;

import com.mio.server.exceptions.DuplicateAttributeException;
import com.mio.server.models.Board;
import com.mio.server.models.Point;
import com.mio.server.models.World;
import com.mio.server.models.WorldConfig;

import java.util.ArrayList;
import java.util.List;

public class WorldBuilder {

    private String name;
    private Double rows;
    private Double cols;
    private WorldConfig worldConfig;
    private List<Board> boards;
    private List<Point> boxes;
    private List<Point> targets;
    private Point player;

    public WorldBuilder() {
    }

    public WorldBuilder withName(String name) throws DuplicateAttributeException {
        if(this.name != null){
            throw new DuplicateAttributeException("el nombre del mundo ya ha sido declarado");
        }
        this.name = name;
        return this;
    }

    public WorldBuilder withRows(Double rows) throws DuplicateAttributeException {
        if(this.rows != null){
            throw new DuplicateAttributeException("El número de filas ya ha sido declarado.");
        }
        this.rows = rows;
        return this;
    }

    public WorldBuilder withCols(Double cols) throws DuplicateAttributeException {
        if(this.cols != null){
            throw new DuplicateAttributeException("El número de filas ya ha sido declarado.");
        }
        this.cols = cols;
        return this;
    }

    public WorldBuilder withConfig(WorldConfig config) throws DuplicateAttributeException {
        if(this.worldConfig != null){
            throw new DuplicateAttributeException("Las configuraciones ya han sido declaradas");
        }
        this.worldConfig = config;
        return this;
    }

    public WorldBuilder withBoard(Board board){
        if(this.boards == null){

            this.boards = new ArrayList<>();
        }

        this.boards.add(board);
        return this;
    }

    public WorldBuilder withBox(Point box){
        if(this.boxes == null){
            this.boxes = new ArrayList<>();
        }
        this.boxes.add(box);
        return this;

    }

    public WorldBuilder withTarget(Point target){
        if(this.targets == null){
            this.targets = new ArrayList<>();
        }
        this.targets.add(target);
        return this;

    }

    public WorldBuilder withBoards(List<Board> boards) throws DuplicateAttributeException {
        if(this.boards != null){
            throw new DuplicateAttributeException("El atributo Boards ya ha sido declarado");
        }

        this.boards = boards;
        return this;

    }

    public WorldBuilder withBoxes(List<Point> boxes) throws DuplicateAttributeException {
        if(this.boxes != null){
            throw new DuplicateAttributeException("El atributo boxes ya ha sido declarado");
        }
        this.boxes = boxes;
        return this;
    }

    public WorldBuilder withTargets(List<Point> targets) throws DuplicateAttributeException {
        if(this.targets != null){
            throw new DuplicateAttributeException("El atributo targets ya ha sido declarado");
        }

        this.targets = targets;
        return this;

    }

    public WorldBuilder withPlayer(Point player) throws DuplicateAttributeException {
        if(this.player != null){
            throw new DuplicateAttributeException("La posición del jugador ya ha sido declarada");
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

    public Double getRows() {
        return rows;
    }

    public Double getCols() {
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

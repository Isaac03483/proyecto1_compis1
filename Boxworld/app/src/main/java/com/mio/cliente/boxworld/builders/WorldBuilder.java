package com.mio.cliente.boxworld.builders;


import com.mio.cliente.boxworld.models.Board;
import com.mio.cliente.boxworld.models.Point;
import com.mio.cliente.boxworld.models.WConfig;
import com.mio.cliente.boxworld.models.World;

import java.util.ArrayList;
import java.util.List;

public class WorldBuilder {

    private String name;
    private Integer rows;
    private Integer cols;
    private WConfig worldConfig;
    private List<Board> boards;
    private List<Point> boxes;
    private List<Point> targets;
    private Point player;

    public WorldBuilder() {
    }

    public WorldBuilder withName(String name){
        this.name = name;
        return this;
    }

    public WorldBuilder withRows(Integer rows) {
        this.rows = rows;
        return this;
    }

    public WorldBuilder withCols(Integer cols)  {
        this.cols = cols;
        return this;
    }

    public WorldBuilder withConfig(WConfig config){
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

    public WorldBuilder withBoards(List<Board> boards){
        this.boards = boards;
        return this;

    }

    public WorldBuilder withBoxes(List<Point> boxes) {
        this.boxes = boxes;
        return this;
    }

    public WorldBuilder withTargets(List<Point> targets){
        this.targets = targets;
        return this;

    }

    public WorldBuilder withPlayer(Point player) {
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

    public WConfig getWorldConfig() {
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

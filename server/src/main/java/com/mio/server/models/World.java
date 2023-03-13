package com.mio.server.models;

import com.mio.server.builders.WorldBuilder;

import java.util.List;

public class World {

    private final String name;
    private final Double rows;
    private final Double cols;
    private WorldConfig worldConfig;
    private final List<Board> board;
    private final List<Point> boxes;
    private final List<Point> targets;
    private final Point player;

    public World(WorldBuilder builder) {
        this.name = builder.getName();
        this.rows = builder.getRows();
        this.cols = builder.getCols();
        this.worldConfig = builder.getWorldConfig();
        this.board = builder.getBoards();
        this.boxes = builder.getBoxes();
        this.targets = builder.getTargets();
        this.player = builder.getPlayer();
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

    public List<Board> getBoard() {
        return board;
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

    @Override
    public String toString() {
        return "World{" +
                "name='" + name + '\'' +
                ", rows=" + rows +
                ", cols=" + cols +
                "\n, worldConfig=" + worldConfig +
                "\n, board=" + board +
                "\n, boxes=" + boxes +
                "\n, targets=" + targets +
                "\n, player=" + player +
                '}';
    }

    public void setWorldConfig(WorldConfig worldConfig) {
        this.worldConfig = worldConfig;
    }
}

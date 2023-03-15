package com.mio.cliente.boxworld.builders;

import com.mio.cliente.boxworld.models.Board;
import com.mio.cliente.boxworld.models.Point;
import com.mio.cliente.boxworld.models.World;

import java.io.Serializable;
import java.util.List;

public class MatrixBuilder implements Serializable {

    public Board[][] makeMatrix(World world){
        Board[][] boards = new Board[world.getRows()][world.getCols()];
        world.getBoard().forEach(board -> {
            Point point = board.getPoint();
            boards[point.getPosX()][point.getPosY()] = board;
        });

        world.getBoxes().forEach(box ->{
            boards[box.getPosX()][box.getPosY()].setHasBox(true);
        });

        world.getTargets().forEach(target ->{
            boards[target.getPosX()][target.getPosY()].setHasTarget(true);
        });

        boards[world.getPlayer().getPosX()][world.getPlayer().getPosY()].setHasPlayer(true);

        return boards;
    }
}

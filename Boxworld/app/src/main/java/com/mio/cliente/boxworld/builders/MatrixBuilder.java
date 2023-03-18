package com.mio.cliente.boxworld.builders;

import com.mio.cliente.boxworld.models.Board;
import com.mio.cliente.boxworld.models.Point;
import com.mio.cliente.boxworld.models.World;

import java.io.Serializable;
import java.util.List;

public class MatrixBuilder implements Serializable {

    public Board[][] makeMatrix(World world){
        try {
            System.out.println("world.getCols() = " + world.getCols());
            Board[][] boards = new Board[world.getRows()][world.getCols()];
            System.out.println("boards = " + boards.length + " "+boards[0].length);
            world.getBoard().forEach(board -> {
                Point point = board.getPoint();
                System.out.println("point = " + point);
                boards[point.getPosY()][point.getPosX()] = board;
            });

            world.getBoxes().forEach(box ->{
                boards[box.getPosY()][box.getPosX()].setHasBox(true);
            });

            world.getTargets().forEach(target ->{
                boards[target.getPosY()][target.getPosX()].setHasTarget(true);
            });

            boards[world.getPlayer().getPosY()][world.getPlayer().getPosX()].setHasPlayer(true);

            return boards;
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("No se pudo crear la matriz");
        }
        return new Board[1][1];
    }
}

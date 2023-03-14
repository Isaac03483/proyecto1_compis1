package com.mio.server.checkers;

import com.mio.server.builders.PointBuilder;
import com.mio.server.compiler.parser.JsonParserSym;
import com.mio.server.models.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class WorldChecker {

    private List<WorldError> worldErrors;
    private World world;

    private IntChecker checker;
    private PointChecker pointChecker;
    private BoardChecker boardChecker;


    public WorldChecker(List<WorldError> worldErrors, World world) {
        this.worldErrors = worldErrors;
        this.world = world;
        checker = new IntChecker(worldErrors);
        pointChecker = new PointChecker(worldErrors, checker);
        boardChecker = new BoardChecker(worldErrors, pointChecker);
    }

    public void checkAll(){

        checkName();
        checkRows();
        checkCols();
        checkConfig();
        checkBoard();
        checkBoxes();
        checkTargets();
        checkPlayer();
    }

    private void checkName(){
        if(world.getName() == null){
            worldErrors.add(new WorldError("atributo name",1,1, ErrorType.SEMANTICO, "El nombre del mundo no ha sido declarado"));
        }
    }

    private void checkRows(){
        if(world.getRows() == null){
            worldErrors.add(new WorldError("Atributo rows",1,1, ErrorType.SEMANTICO, "El número de filas del mundo no ha sido declarado"));
        }

        checker.checkValue(world.getRows());
    }

    private void checkCols(){
        if(world.getCols() == null){
            worldErrors.add(new WorldError("Atributo cols",1,1, ErrorType.SEMANTICO, "El número de columnas del mundo no ha sido declarado"));
        }

        checker.checkValue(world.getCols());
    }

    private void checkConfig(){
        if(world.getWorldConfig() == null){
            world.setWorldConfig(WorldConfig.defaultConfig);
            return;
        }
        new ConfigChecker(world.getWorldConfig()).checkAll();
    }

    private void checkBoard(){

        if(world.getBoard() == null){
            worldErrors.add(new WorldError(null, 1,1,ErrorType.SEMANTICO, "El tablero del mundo no ha sido declarado"));
            return;
        }

        world.getBoard().forEach(board -> boardChecker.checkAll(board));

    }

    private void checkTargets(){
        if(world.getBoard() == null){
            worldErrors.add(new WorldError(null, 1,1,ErrorType.SEMANTICO, "El tablero del mundo no ha sido declarado"));

            return;
        }

        if(world.getTargets() == null){
            worldErrors.add(new WorldError(null, 1,1,ErrorType.SEMANTICO, "Los objetivos del mundo no han sido declarados"));

            return;
        }

        world.getTargets().forEach(target -> {
            Optional<Point> point = world.getBoard().stream().map(board -> {
                if(board.getType().equals(JsonParserSym.terminalNames[JsonParserSym.HALL])){
                    return board.getPoint();
                }

                return null;
            }).filter(point1 -> Objects.equals(point1, target)).findFirst();

            if(point.isEmpty()){
                worldErrors.add(new WorldError(null, 0,0,ErrorType.SEMANTICO, "La coordenada del objetivo no se ha encontrado en el tablero"));
            }
        });
    }

    private void checkBoxes(){
        if(world.getBoard() == null){
            worldErrors.add(new WorldError(null, 1,1,ErrorType.SEMANTICO, "El tablero del mundo no ha sido declarado"));

            return;
        }

        if(world.getBoxes() == null){
            worldErrors.add(new WorldError(null, 1,1,ErrorType.SEMANTICO, "Las cajas del mundo no han sido declaradas"));

            return;
        }

        world.getBoxes().forEach(box -> {
            Optional<Point> point = world.getBoard().stream().map(board -> {
                if(board.getType().equals(JsonParserSym.terminalNames[JsonParserSym.HALL])){
                    return board.getPoint();
                }
                return null;
            }).filter(point1 -> Objects.equals(point1, box)).findFirst();

            if(point.isEmpty()){
                worldErrors.add(new WorldError(null, 0,0,ErrorType.SEMANTICO, "La coordenada de la caja no se ha encontrado en el mundo"));
            }
        });
    }

    private void checkPlayer(){
        if(world.getPlayer() == null){
            worldErrors.add(new WorldError(null, 1,1,ErrorType.SEMANTICO, "La posición del jugador en el tablero no ha sido declarado"));
            return;
        }

        pointChecker.checkAll(world.getPlayer());
    }

}

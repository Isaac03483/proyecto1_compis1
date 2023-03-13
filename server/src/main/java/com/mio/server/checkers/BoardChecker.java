package com.mio.server.checkers;

import com.mio.server.models.Board;
import com.mio.server.models.ErrorType;
import com.mio.server.models.Point;
import com.mio.server.models.WorldError;

import java.util.List;

public class BoardChecker {

    private List<WorldError> worldErrors;
    private PointChecker pointChecker;

    public BoardChecker(List<WorldError> worldErrors, PointChecker pointChecker) {
        this.worldErrors = worldErrors;
        this.pointChecker = pointChecker;
    }

    public void checkAll(Board board){
        checkPoint(board.getPoint());
        checkType(board.getType());
    }

    private void checkPoint(Point point){
        pointChecker.checkAll(point);
    }

    private void checkType(Integer type){
        if (type == null) {
            worldErrors.add(new WorldError(null, -1,-1, ErrorType.SEMANTICO, "El tipo de tablero no se ha definido."));
        }
    }
}

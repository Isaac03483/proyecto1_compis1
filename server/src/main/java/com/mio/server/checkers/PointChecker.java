package com.mio.server.checkers;

import com.mio.server.models.ErrorType;
import com.mio.server.models.Point;
import com.mio.server.models.WorldError;

import java.util.List;

public class PointChecker {

    private List<WorldError> worldErrors;
    private IntChecker checker;

    public PointChecker(List<WorldError> worldErrors, IntChecker checker) {
        this.worldErrors = worldErrors;
        this.checker = checker;
    }

    public void checkAll(Point point){

        checkPosX(point);
        checkPosY(point);
    }

    private void checkPosX(Point point){

        if(point.getPosX() == null){
            worldErrors.add(new WorldError(null, 0,0, ErrorType.SEMANTICO, "La posición X no puede ser nula"));
            return;
        }

        checker.checkValue(point.getPosX());
    }

    private void checkPosY(Point point){

        if(point.getPosY() == null){
            worldErrors.add(new WorldError(null, 0,0, ErrorType.SEMANTICO, "La posición Y no puede ser nula"));
            return;
        }

        checker.checkValue(point.getPosY());
    }


}

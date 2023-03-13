package com.mio.server.checkers;

import com.mio.server.models.ErrorType;
import com.mio.server.models.WorldError;

import java.util.ArrayList;
import java.util.List;

public class IntChecker {

    private List<WorldError> errors;

    public IntChecker(List<WorldError> errors) {
        this.errors = errors;
    }

    public void checkValue(Double value){
        String str = String.valueOf(value);
        float decPart = Float.parseFloat(str.substring(str.indexOf(".")));
        System.out.println(decPart);
        if(decPart != 0.0){
            errors.add(new WorldError(value.toString(), -1,-1, ErrorType.SEMANTICO, "El número debe ser un valor entero"));
        }

    }

}

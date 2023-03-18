package com.mio.cliente.boxworld.checkers

import com.mio.cliente.boxworld.builders.ErrorBuilder
import com.mio.cliente.boxworld.models.ErrorType
import com.mio.cliente.boxworld.models.Move
import com.mio.cliente.boxworld.models.ParserError

class MovesChecker(private val errorList: ArrayList<ParserError>, private val moves: ArrayList<Move>) {

    fun checkAll(){
        moves.forEach {
            checkNumber(it.number)
        }
    }


    private fun checkNumber(value: Double){
        val str: String = value.toString()
        val decPart = str.substring(str.indexOf(".")).toFloat()
        println(decPart)
        if (decPart.toDouble() != 0.0) {
            errorList.add(ParserError(
//                value.toString(), 0, 0, ErrorType.SEMANTICO, "El número debe ser un valor entero")
                ErrorBuilder().withLexema(value.toString()).withLine(0).withColumn(0)
                    .withErrorType(ErrorType.SEMANTICO).withDescription("El número debe ser un valor entero")
            ))
        }
    }


}
package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.builders.ErrorBuilder
import java.io.Serializable

data class ParserError(val errorBuilder: ErrorBuilder): Serializable {

    var lexema = errorBuilder.lexema
    var line = errorBuilder.line
    var column = errorBuilder.column
    var type = errorBuilder.errorType
    var description = errorBuilder.description

}
package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.builders.ErrorBuilder

class WorldError(val errorBuilder: ErrorBuilder) {

    var lexema = errorBuilder.lexema
    var line = errorBuilder.line
    var column = errorBuilder.column
    var type = errorBuilder.errorType
    var Description = errorBuilder.description

}

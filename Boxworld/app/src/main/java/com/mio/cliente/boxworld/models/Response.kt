package com.mio.cliente.boxworld.models

import java.io.Serializable

data class Response(val responseType: ResponseType, val world: World?, val errors: ArrayList<ParserError>?, val worldNames: ArrayList<String>?): Serializable {
}
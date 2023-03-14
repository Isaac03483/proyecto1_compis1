package com.mio.cliente.boxworld.models

class Response(val responseType: ResponseType, val world: World?, val errors: ArrayList<WorldError>?, val worldNames: ArrayList<String>?) {
}
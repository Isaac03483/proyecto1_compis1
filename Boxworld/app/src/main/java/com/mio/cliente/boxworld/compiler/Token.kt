package com.mio.cliente.boxworld.compiler

import java.io.Serializable

data class Token(val type: Int,val value: String?,val line: Int,val column: Int): Serializable{

}
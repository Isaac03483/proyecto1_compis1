package com.mio.cliente.boxworld.models

import com.mio.cliente.boxworld.compiler.Token
import java.io.Serializable


class MovesReport(val movesToken: ArrayList<Token>?, val arithmeticToken: ArrayList<Token>?, val movesCount: MovesCount?): Serializable {
}
package com.mio.cliente.boxworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mio.cliente.boxworld.compiler.lexer.MovesLexer
import com.mio.cliente.boxworld.compiler.parser.MovesParserHandle
import java.io.StringReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lexer()
    }

    fun lexer(){
        val codigo = "down (2 * 5 / 10);\n" +
                "\n" +
                "# empujando la caja hacia la derecha\n" +
                "push right (6 - 5);\n" +
                "\n" +
                "# hacia la izquierda una casilla\n" +
                "left (6 / 2 - 2);\n" +
                "\n" +
                "# hacia arriba una casilla\n" +
                "down (-1);"

        MovesParserHandle().compile(codigo)

    }
}
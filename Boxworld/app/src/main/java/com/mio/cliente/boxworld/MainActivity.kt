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
        /*val codigo = "down (3 * 5 / 10);\n" +
                "\n" +
                "# empujando la caja hacia la derecha\n" +
                "push right ( (10 - 5) *3);\n" +
                "\n" +
                "# hacia la izquierda una casilla\n" +
                "left (6 / 3 - 2);\n" +
                "\n" +
                "# hacia arriba una casilla\n" +
                "down (CEIL(7 + FLOOR(4.5)));"*/
        val codigo = "push left ((4*4)/(3+3));" +
                "push left (FLOOR ((4.2*2)) * 3 - 5);"

        MovesParserHandle().compile(codigo)

    }
}
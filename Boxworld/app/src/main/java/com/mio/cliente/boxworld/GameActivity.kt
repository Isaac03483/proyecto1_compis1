package com.mio.cliente.boxworld

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.mio.cliente.boxworld.checkers.MovesChecker
import com.mio.cliente.boxworld.compiler.Token
import com.mio.cliente.boxworld.compiler.parser.MovesParserHandle
import com.mio.cliente.boxworld.compiler.parser.MovesParserSym
import com.mio.cliente.boxworld.models.*
import kotlin.concurrent.thread

class GameActivity : AppCompatActivity() {

    private var frameLayout: FrameLayout?= null
    private var movesReportButton: Button? = null
    private var compileButton: Button? = null
    var moves: ArrayList<Move>? = null
    var errors: ArrayList<ParserError>? = null
    var arithmeticToken: ArrayList<Token>?= null
    var movesToken: ArrayList<Token>?=null
    var movesCount: MovesCount? = null
    var movesReport: MovesReport? = null
    var world: World? = null
    var tvWait: TextView? = null

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.rgb(137,207,240)))

        val response = intent.getSerializableExtra("response", Response::class.java)!!

        world = response.world

        frameLayout = findViewById(R.id.frameLayout)
        movesReportButton = findViewById(R.id.movesReportButton)
        compileButton = findViewById(R.id.movesCompilerButton)
        val text = findViewById<TextView>(R.id.GameTitleText)
        tvWait = findViewById(R.id.tvWait)
        text.text = world?.name
        val drawPanel = DrawPanel(this, world!!)
        frameLayout?.addView(drawPanel)


        initCompileButton()
        initReportButton()
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun initCompileButton(){
        val movesText = findViewById<EditText>(R.id.moveText)
        compileButton?.setOnClickListener {

            val moveText = movesText.text
            if(moveText.equals("")){
                Toast.makeText(this,  "No se puede analizar la cadena vacía.", Toast.LENGTH_SHORT).show()

            } else {
                try {
                    val movesParserHandle = MovesParserHandle()
                    movesParserHandle.compile(moveText.toString())
                    errors = movesParserHandle.errors
                    moves = movesParserHandle.moves
                    arithmeticToken = movesParserHandle.arithmeticToken
                    movesToken = movesParserHandle.movesToken
                    movesCount = movesParserHandle.movesCount
                    movesReport = MovesReport(movesToken, arithmeticToken, movesCount)
                    movesReportButton?.isEnabled = true

                    val movesChecker = MovesChecker(errors!!, moves!!)
                    movesChecker.checkAll()


                    if(errors?.isEmpty() == false){
                        val response = Response(ResponseType.ERRORS, null, errors, null)
                        val intent = Intent(this, ErrorActivity::class.java).putExtra("response", response)
                        startActivity(intent)
                    }

                    updatePanel()

                } catch (e: Exception){
                    e.printStackTrace()
                    Toast.makeText(this,  "No se puede analizar la cadena.", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun initReportButton(){
        movesReportButton?.setOnClickListener {
            val intent = Intent(this, MovesReportActivity::class.java)
            intent.putExtra("movesReport", movesReport)
            startActivity(intent)
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun updatePanel(){

        thread {
            moves?.forEach{
                world?.movePlayer(it)
                println("Realizando movimiento")
                println("${it.direction} -> ${it.number}")

                this@GameActivity.runOnUiThread {
                    tvWait?.text = "Moviendo en dirección ${MovesParserSym.terminalNames[it.direction]}"
                    frameLayout?.removeAllViews()

                    println("Actualizando información")
                    val drawPanel = DrawPanel(this, world!!)
                    println("Agregando panel nuevo")
                    frameLayout?.addView(drawPanel)
//                    drawPanel?.rewrite()
                }
                try {
                    Thread.sleep(1000)
                } catch (e: Exception){
                    e.printStackTrace()
                }

            }
        }
    }

}
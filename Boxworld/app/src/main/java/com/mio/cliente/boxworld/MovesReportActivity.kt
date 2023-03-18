package com.mio.cliente.boxworld

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.forEach
import com.mio.cliente.boxworld.compiler.Token
import com.mio.cliente.boxworld.compiler.parser.MovesParserSym
import com.mio.cliente.boxworld.models.MovesCount
import com.mio.cliente.boxworld.models.MovesReport
import java.util.ArrayList

class MovesReportActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moves_report)

        val movesReport = intent.getSerializableExtra("movesReport", MovesReport::class.java)

        setMovesTokenTable(movesReport?.movesToken)
        setMovesCountTable(movesReport?.movesCount)
        setArithmeticTokenTable(movesReport?.arithmeticToken)
    }

    private fun setArithmeticTokenTable(arithmeticToken: ArrayList<Token>?) {
        val arithmeticTokenTable = findViewById<TableLayout>(R.id.arithmeticTokenTable)
        arithmeticTokenTable.removeAllViews()
        val header = LayoutInflater.from(this).inflate(R.layout.three_rows, null, false)
        val tvOp = header.findViewById<TextView>(R.id.threeTv0)
        val tvLine = header.findViewById<TextView>(R.id.threeTv1)
        val tvCol = header.findViewById<TextView>(R.id.threeTv2)

        tvOp.setTextColor(Color.BLACK)
        tvOp.text = "Operación"
        tvLine.setTextColor(Color.BLACK)
        tvLine.text = "Linea"
        tvCol.setTextColor(Color.BLACK)
        tvCol.text = "Columna"

        arithmeticTokenTable.addView(header)

        arithmeticToken?.forEach {
            val row = LayoutInflater.from(this).inflate(R.layout.three_rows, null, false)
            val tv0 = row.findViewById<TextView>(R.id.threeTv0)
            val tv1 = row.findViewById<TextView>(R.id.threeTv1)
            val tv2 = row.findViewById<TextView>(R.id.threeTv2)

            tv0.text = MovesParserSym.terminalNames[it.type]
            tv1.text = it.line.toString()
            tv2.text = it.column.toString()

            arithmeticTokenTable.addView(row)
        }

    }

    private fun setMovesCountTable(movesCount: MovesCount?) {

        val movesCountTable = findViewById<TableLayout>(R.id.movesCountTable)
        movesCountTable.removeAllViews()
        val h = LayoutInflater.from(this).inflate(R.layout.two_rows, null, false)
        val tvDir = h.findViewById<TextView>(R.id.twoTv0)
        val tvCan = h.findViewById<TextView>(R.id.twoTv1)

        tvDir.setTextColor(Color.BLACK)
        tvCan.setTextColor(Color.BLACK)
        tvDir.text = "Dirección"
        tvCan.text = "Cantidad"

        movesCountTable.addView(h)

        val row0 = LayoutInflater.from(this).inflate(R.layout.two_rows, null, false)
        val tvLD = row0.findViewById<TextView>(R.id.twoTv0)
        val tvLC = row0.findViewById<TextView>(R.id.twoTv1)

        tvLD.text = "LEFT"
        tvLC.text = movesCount?.left.toString()

        movesCountTable.addView(row0)

        val row1 = LayoutInflater.from(this).inflate(R.layout.two_rows, null, false)
        val tvRD = row1.findViewById<TextView>(R.id.twoTv0)
        val tvRC = row1.findViewById<TextView>(R.id.twoTv1)

        tvRD.text = "RIGHT"
        tvRC.text = movesCount?.right.toString()

        movesCountTable.addView(row1)

        val row2 = LayoutInflater.from(this).inflate(R.layout.two_rows, null, false)
        val tvUD = row2.findViewById<TextView>(R.id.twoTv0)
        val tvUC = row2.findViewById<TextView>(R.id.twoTv1)

        tvUD.text = "UP"
        tvUC.text = movesCount?.up.toString()

        movesCountTable.addView(row2)

        val row3 = LayoutInflater.from(this).inflate(R.layout.two_rows, null, false)
        val tvDD = row3.findViewById<TextView>(R.id.twoTv0)
        val tvDC = row3.findViewById<TextView>(R.id.twoTv1)

        tvDD.text = "DOWN"
        tvDC.text = movesCount?.down.toString()

        movesCountTable.addView(row3)




    }

    private fun setMovesTokenTable(movesToken: ArrayList<Token>?) {

        val movesTokenTable = findViewById<TableLayout>(R.id.movesTokenTable)
        movesTokenTable.removeAllViews()
        val header = LayoutInflater.from(this).inflate(R.layout.three_rows, null, false)
        val tvOp = header.findViewById<TextView>(R.id.threeTv0)
        val tvLine = header.findViewById<TextView>(R.id.threeTv1)
        val tvCol = header.findViewById<TextView>(R.id.threeTv2)

        tvOp.setTextColor(Color.BLACK)
        tvOp.text = "Instrucción"
        tvLine.setTextColor(Color.BLACK)
        tvLine.text = "Linea"
        tvCol.setTextColor(Color.BLACK)
        tvCol.text = "Columna"

        movesTokenTable.addView(header)

        movesToken?.forEach {
            val row = LayoutInflater.from(this).inflate(R.layout.three_rows, null, false)
            val tv0 = row.findViewById<TextView>(R.id.threeTv0)
            val tv1 = row.findViewById<TextView>(R.id.threeTv1)
            val tv2 = row.findViewById<TextView>(R.id.threeTv2)

            tv0.text = MovesParserSym.terminalNames[it.type]
            tv1.text = it.line.toString()
            tv2.text = it.column.toString()

            movesTokenTable.addView(row)
        }
    }
}
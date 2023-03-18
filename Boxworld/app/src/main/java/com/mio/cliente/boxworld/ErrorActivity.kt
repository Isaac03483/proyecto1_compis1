package com.mio.cliente.boxworld

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TableLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.mio.cliente.boxworld.compiler.parser.XMLParserSym
import com.mio.cliente.boxworld.models.Response
import com.mio.cliente.boxworld.models.ParserError

class ErrorActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)
        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.rgb(137,207,240)))
        val response = intent.getSerializableExtra("response", Response::class.java)!!

        val errors = response.errors
        setTable(errors!!)

    }

    private fun setTable(errors: ArrayList<ParserError>){

        val errorTable = findViewById<TableLayout>(R.id.errorTable)
        errorTable.removeAllViews()
        val headers = LayoutInflater.from(this).inflate(R.layout.error_row, null, false)
        val tvLexemeH = headers.findViewById<TextView>(R.id.tvLexeme)
        val tvLineH = headers.findViewById<TextView>(R.id.tvLine)
        val tvColH = headers.findViewById<TextView>(R.id.tvCol)
        val tvTypeH = headers.findViewById<TextView>(R.id.tvType)
        val tvDescH = headers.findViewById<TextView>(R.id.tvDesc)

        tvLexemeH.text = "Lexema"
        tvLexemeH.setTextColor(Color.BLACK)
        tvLineH.text ="Line"
        tvLineH.setTextColor(Color.BLACK)
        tvColH.text = "Column"
        tvColH.setTextColor(Color.BLACK)
        tvTypeH.text = "Type"
        tvTypeH.setTextColor(Color.BLACK)
        tvDescH.text = "Description"
        tvDescH.setTextColor(Color.BLACK)
        errorTable.addView(headers)

        errors.forEach {
            val row = LayoutInflater.from(this).inflate(R.layout.error_row, null, false)

            val tvLexeme = row.findViewById<TextView>(R.id.tvLexeme)
            val tvLine = row.findViewById<TextView>(R.id.tvLine)
            val tvCol = row.findViewById<TextView>(R.id.tvCol)
            val tvType = row.findViewById<TextView>(R.id.tvType)
            val tvDesc = row.findViewById<TextView>(R.id.tvDesc)

            tvLexeme.text =it.lexema
            tvLine.text = it.line.toString()
            tvCol.text = it.column.toString()
            tvType.text = it.type.toString()
            tvDesc.text = it.description

            errorTable.addView(row)
        }

    }
}
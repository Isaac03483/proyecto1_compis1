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
import com.mio.cliente.boxworld.models.Response
import java.util.ArrayList

class NamesActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_names)
        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.rgb(137,207,240)))

        val response = intent.getSerializableExtra("response", Response::class.java)!!

        val worldNames= response.worldNames

        setNames(worldNames)
    }

    private fun setNames(worldNames: ArrayList<String>?) {
        val namesTable = findViewById<TableLayout>(R.id.nameTable)
        namesTable.removeAllViews()

        val row = LayoutInflater.from(this).inflate(R.layout.two_rows, null, false)
        val tvNum = row.findViewById<TextView>(R.id.twoTv0)
        val tvName = row.findViewById<TextView>(R.id.twoTv1)

        tvNum.text = "# de mundo"
        tvNum.setTextColor(Color.BLACK)
        tvName.text = "Nombre"
        tvName.setTextColor(Color.BLACK)
        namesTable.addView(row)
        var count = 0
        worldNames?.forEach {
            count+=1
            val rowInfo = LayoutInflater.from(this).inflate(R.layout.two_rows, null, false)

            val tvNumRow = rowInfo.findViewById<TextView>(R.id.twoTv0)
            tvNumRow.text = count.toString()
            val tvNameRow = rowInfo.findViewById<TextView>(R.id.twoTv1)
            tvNameRow.text = it
            namesTable.addView(rowInfo)


        }

    }
}
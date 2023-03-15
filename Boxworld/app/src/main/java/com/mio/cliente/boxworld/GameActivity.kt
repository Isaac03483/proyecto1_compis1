package com.mio.cliente.boxworld

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import com.mio.cliente.boxworld.models.Response

class GameActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val response = intent.getSerializableExtra("response", Response::class.java)!!

        val world = response.world

        println(world)

        println("Acá debería dibujar el juego con el drawPanel")

        val frameLayout = findViewById<FrameLayout>(R.id.frameLayout)
        val drawPanel = DrawPanel(this, world!!)
        frameLayout.addView(drawPanel)




    }
}
package com.mio.cliente.boxworld

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar
import com.mio.cliente.boxworld.compiler.parser.MovesParserHandle
import com.mio.cliente.boxworld.compiler.parser.XMLParserHandler
import com.mio.cliente.boxworld.models.ResponseType
import java.io.DataInputStream
import java.io.DataOutputStream
import java.io.IOException
import java.net.ConnectException
import java.net.InetAddress
import java.net.Socket
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {

    private var host:String? = "192.168.0.107"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val actionBar = supportActionBar
        actionBar?.setBackgroundDrawable(ColorDrawable(Color.rgb(137,207,240)))
//        lexer()
        initSocket()
    }

    private fun initSocket(){

        findViewById<Button>(R.id.compileButton).setOnClickListener {
            Log.d("mensaje", "Conectandose al servidor...")
            try{
                Executors.newSingleThreadExecutor().execute {
//                    host = InetAddress.getLocalHost().hostAddress
//                    println("El host es: $host")
                    val socket = Socket(host, 50000)

                    val dataInput = DataInputStream(socket.getInputStream())
                    val dataOutput = DataOutputStream(socket.getOutputStream())

                    val et = findViewById<EditText>(R.id.jsonText)

                    val text = et.text
                    println("Información enviada al servidor ${text}")
                    dataOutput.writeUTF(text.toString())

                    val responseContent = dataInput.readUTF()

//                    println(mensaje)

                    try{
                        val xmlParserHandler = XMLParserHandler().compile(responseContent)

                        if(xmlParserHandler.responseType == ResponseType.WORLD){
                            println("Se recibió un mundo para mostrar. ${xmlParserHandler.world}")
                        } else if(xmlParserHandler.responseType == ResponseType.WORLD_NAMES){
                            println("Se recibió un arreglo de nombres para mostrar.")
                            xmlParserHandler.worldNames?.forEach {
                                println(it)
                            }
                        } else {
                            println("Se recibió un arreglo de errores.")
                        }

                    }catch (e: Exception){
//                        Toast.makeText(this, "Imposible analizar la información del servidor", Toast.LENGTH_SHORT).show()
                    }


                }
            }catch (e: Exception){

                Toast.makeText(this,"Imposible conectarse al servidor.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
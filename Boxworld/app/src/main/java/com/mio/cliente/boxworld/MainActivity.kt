package com.mio.cliente.boxworld

import android.content.Intent
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
import com.mio.cliente.boxworld.models.Response
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

    private fun goToActivity(response: Response){
        println("Entrando a goToActivity con response: ${response.responseType}")
        when (response.responseType) {
            ResponseType.WORLD -> {
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra("response", response)
                startActivity(intent)
            }
            ResponseType.WORLD_NAMES -> {
                val intent = Intent(this, NamesActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("response", response)
                intent.putExtras(bundle)

                startActivity(intent)

            }
            else -> {
                val intent = Intent(this, ErrorActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("response", response)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    private fun initSocket(){

        findViewById<Button>(R.id.compileButton).setOnClickListener {


            var responseContent = ""


            try{
                Executors.newSingleThreadExecutor().execute {
                    Log.d("mensaje", "Conectandose al servidor...")
//                    host = InetAddress.getLocalHost().hostAddress
//                    println("El host es: $host")
                    val socket = Socket(host, 50000)

                    val dataInput = DataInputStream(socket.getInputStream())
                    val dataOutput = DataOutputStream(socket.getOutputStream())

                    val et = findViewById<EditText>(R.id.jsonText)

                    val text = et.text
                    println("Información enviada al servidor ${text}")
                    dataOutput.writeUTF(text.toString())

                    responseContent = dataInput.readUTF()

                    readResponse(responseContent)
                }

            }catch (e: Exception){

                Toast.makeText(this,"Imposible conectarse al servidor.", Toast.LENGTH_SHORT).show()
            }

        }

    }
    
    private fun readResponse(responseContent: String){
        if(responseContent == ""){
            Toast.makeText(this, "No se ha recibido nada del servidor.", Toast.LENGTH_SHORT).show()
            return
        }

        try{
            val xmlParserHandler = XMLParserHandler().compile(responseContent)

            goToActivity(xmlParserHandler)

        }catch (e: Exception){
//            Toast.makeText(this, "Imposible analizar la información del servidor", Toast.LENGTH_SHORT).show()
            e.printStackTrace()
        }
    }
}
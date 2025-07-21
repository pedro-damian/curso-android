package com.pedrodamian.pildorasinformaticas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val et: EditText = findViewById(R.id.et)
        val boton: Button = findViewById(R.id.button)
        val resultado: TextView = findViewById(R.id.textView)
        val restar: Button = findViewById(R.id.btn_restar)
        val sumar: Button = findViewById(R.id.btn_sumar)

        boton.setOnClickListener {
            val numero = et.text.toString().toIntOrNull()

            // OPCION 1
            /*if (numero==null) {
                resultado.text="Introduce un numero"
            }
            else if(numero<18){
                resultado.text="Eres menor de edad"
            } else if(numero>18){
                resultado.text="Eres mayor de edad"
            } else{
                resultado.text="Tienes 18 años"
            }*/

            // OPCION 2
            /*if (numero==null) resultado.text="Introduce un numero"
            else if(numero<18) resultado.text="Eres menor de edad"
            else if(numero>18) resultado.text="Eres mayor de edad"
            else resultado.text="Tienes 18 años"*/

            // OPCION 3
            resultado.text= if (numero==null) "Introduce un numero"
            else if(numero<18) "Eres menor de edad"
            else if(numero>18) "Eres mayor de edad"
            else "Tienes 18 años"


        }

        sumar.setOnClickListener {
            var numero = et.text.toString().toIntOrNull()
            if (numero==null) resultado.text="Introduce un numero"
            else et.setText((++numero).toString())
        }

        restar.setOnClickListener {
            var numero = et.text.toString().toIntOrNull()
            if (numero==null) resultado.text="Introduce un numero"
            else et.setText((--numero).toString())
        }

    }
}
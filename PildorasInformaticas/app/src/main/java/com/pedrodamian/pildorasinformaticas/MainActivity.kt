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
            /*resultado.text= if (numero==null) "Introduce un numero"
            else if(numero<18) "Eres menor de edad"
            else if(numero>18) "Eres mayor de edad"
            else "Tienes 18 años"*/

            // OPCION 4 (con funcion)
            mostrarMensaje(numero, resultado)
        }

        // Incremento y Decremento
        sumar.setOnClickListener {
            var numero = et.text.toString().toIntOrNull()
            if (numero==null) resultado.text="Introduce un numero"
            else {
                et.setText((++numero).toString())
                // OPCION 1
                /*resultado.text= if (numero==null) "Introduce un numero"
                else if(numero<18) "Eres menor de edad"
                else if(numero>18) "Eres mayor de edad"
                else "Tienes 18 años"*/

                // OPCION 2 (con funcion)
                mostrarMensaje(numero, resultado)
            }
        }

        restar.setOnClickListener {
            var numero = et.text.toString().toIntOrNull()
            if (numero==null) resultado.text="Introduce un numero"
            else {
                et.setText((--numero).toString())
                // OPCION 1
                /*resultado.text= if (numero==null) "Introduce un numero"
                else if(numero<18) "Eres menor de edad"
                else if(numero>18) "Eres mayor de edad"
                else "Tienes 18 años"*/

                // OPCION 2 (con funcion)
                mostrarMensaje(numero, resultado)
            }
        }
    }

    fun mostrarMensaje(numeroEdad:Int?, mensajeTexto: TextView) {
        /*mensajeTexto.text= if (numeroEdad==null) "Introduce un numero"
        else if(numeroEdad<18) "Eres menor de edad"
        else if(numeroEdad>18) "Eres mayor de edad"
        else "Tienes 18 años"*/

        val resultado = when {
            numeroEdad==null -> "Introduce un numero"
            numeroEdad <= 0 || numeroEdad > 150 -> "Introduzca una edad valida"
            numeroEdad >= 18 && numeroEdad <= 30 || numeroEdad >= 51 && numeroEdad <= 80 -> "Descuento de 10%"
            numeroEdad >= 31 && numeroEdad <= 50 -> "Descuento de 20%"

            else -> "No pagan Pasaje"
        }

        mensajeTexto.text = resultado

    }
}
package com.pedrodamian.bucles

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val numero: EditText = findViewById(R.id.et_numero)
        val boton: Button = findViewById(R.id.btn_calcular)
        val resultado: TextView = findViewById(R.id.tv_resultado)


        // NUMERO AL AZAR (1 - 100)
        var numeroAleatorio = Random.nextInt(1,101)

        var intentos = 0


        resultado.text = numeroAleatorio.toString()

        boton.setOnClickListener{
            intentos++

            var numeroIngresado = numero.text.toString().toIntOrNull()

            if (numeroIngresado==null || numeroIngresado<0 || numeroIngresado>100) {
                resultado.text="Ingrese numero entre 1 y 100"
            } else if (numeroIngresado < numeroAleatorio) {
                resultado.text="El numero es mayor"
            } else if (numeroIngresado > numeroAleatorio) {
                resultado.text="El numero es menor"
            } else {
                resultado.text="Correcto!! Lo has logrado en ${intentos} intentos"
            }

        }

    }
}
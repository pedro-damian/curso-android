package com.pedrodamian.bucles

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var nuevoIntento = false   // Interruptor que evita que el bucle continue indeterminadamente
    var valorIntroducido = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val numero: EditText = findViewById(R.id.et_numero)
        val boton: Button = findViewById(R.id.btn_calcular)
        val resultado: TextView = findViewById(R.id.tv_resultado)

        // NUMERO AL AZAR (1 - 100)
        var numeroAleatorio = Random.nextInt(1,101)
        // NUMERO DE INTENTOS
        var intentos = 0

        boton.setOnClickListener{

            valorIntroducido= numero.text.toString().toInt()
            nuevoIntento=true

        }

        GlobalScope.launch(Dispatchers.Main) {
            while (numeroAleatorio!=valorIntroducido){
                if(nuevoIntento){
                    intentos++
                    if(numeroAleatorio<valorIntroducido) {
                        resultado.text = "El numero es menor"
                    } else if (numeroAleatorio>valorIntroducido) {
                        resultado.text = "El numero es mayor"
                    }
                    nuevoIntento=false
                }
                delay(500)  // pausa
            }
            resultado.text="Correcto!! Lohas logrado en ${intentos} intentos"
        }
    }
}
package com.pedrodamian.factorial

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

        val numero: EditText = findViewById(R.id.et_numero)
        val boton: Button = findViewById(R.id.btn_calcular)
        val resultado: TextView = findViewById(R.id.tv_resultado)

        boton.setOnClickListener {
            val numeroIntroducido = numero.text.toString().toIntOrNull()

            if (numeroIntroducido!=null) {
                val factorial = calcularFactorial(numeroIntroducido)
                resultado.text = "EL factorial de ${numeroIntroducido} es ${factorial.toString()}"

            } else {
                resultado.text = "Introduzca un valor numerico"
            }

        }

    }

    fun calcularFactorial(numero: Int): Int {
        var res = 1

        for (i in 1 .. numero) {
            res = res * i
        }
        return res
    }
}
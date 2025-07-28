package com.pedrodamian.poo

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Rectangulo

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rectanguloVista = findViewById<View>(R.id.rectangulo)
        val rectangulo: Rectangulo = Rectangulo(ContextCompat.getColor(this,R.color.red), 10,10)
        val arriba = findViewById<Button>(R.id.btn_arriba)
        val abajo = findViewById<Button>(R.id.btn_abajo)
        val izquierda = findViewById<Button>(R.id.btn_izquierda)
        val derecha = findViewById<Button>(R.id.btn_derecha)
        val tamano = findViewById<Button>(R.id.btn_tamano)
        val color = findViewById<Button>(R.id.btn_color)


        arriba.setOnClickListener {
            rectangulo.moverArriba()
        }


    }
}
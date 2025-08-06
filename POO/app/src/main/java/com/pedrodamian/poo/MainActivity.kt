package com.pedrodamian.poo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Rectangulo
import kotlin.random.Random

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rectanguloVista = findViewById<View>(R.id.rectangulo)

        rectanguloVista.post {
            val inicialx=rectanguloVista.x.toInt()
            val inicialy=rectanguloVista.y.toInt()
            val inicialWidth=rectanguloVista.width
            val inicialHeight=rectanguloVista.height

            val rectangulo: Rectangulo = Rectangulo(ContextCompat.getColor(this,R.color.red), inicialWidth,inicialHeight).apply{
                x=inicialx
                y=inicialy
            }

            val arriba = findViewById<Button>(R.id.btn_arriba)
            val abajo = findViewById<Button>(R.id.btn_abajo)
            val izquierda = findViewById<Button>(R.id.btn_izquierda)
            val derecha = findViewById<Button>(R.id.btn_derecha)
            val tamano = findViewById<Button>(R.id.btn_tamano)
            val color = findViewById<Button>(R.id.btn_color)


            arriba.setOnClickListener {
                rectangulo.moverArriba()
                actualizarCambios(rectangulo, rectanguloVista)
            }

            abajo.setOnClickListener {
                rectangulo.moverAbajo()
                actualizarCambios(rectangulo, rectanguloVista)
            }

            izquierda.setOnClickListener {
                rectangulo.moverIzquierda()
                actualizarCambios(rectangulo, rectanguloVista)
            }

            derecha.setOnClickListener {
                rectangulo.moverDerecha()
                actualizarCambios(rectangulo, rectanguloVista)
            }

            tamano.setOnClickListener {
                rectangulo.cambiarTamaño(150,150)
                actualizarCambios(rectangulo, rectanguloVista)
            }

            color.setOnClickListener {
                //rectangulo.color = ContextCompat.getColor(this,R.color.blue)
                rectangulo.color =generarColorAleatorio()
                actualizarCambios(rectangulo, rectanguloVista)
            }
        }


    }

    fun generarColorAleatorio(): Int {
        val numero= Random.Default
        val rojo = numero.nextInt(256)
        val verde = numero.nextInt(256)
        val azul = numero.nextInt(256)
        return Color.rgb(rojo,verde,azul)
    }


    fun actualizarCambios(rectangulo: Rectangulo, rectanguloVista: View) {
        rectanguloVista.layoutParams.width=rectangulo.ancho
        rectanguloVista.layoutParams.height=rectangulo.alto

        rectanguloVista.setBackgroundColor(rectangulo.color)

        rectanguloVista.x=rectangulo.x.toFloat()
        rectanguloVista.y=rectangulo.y.toFloat()

        rectanguloVista.requestLayout()
    }
}
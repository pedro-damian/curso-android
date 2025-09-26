package com.pedrodamian.poo

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import model.Rectangulo
import model.RectanguloBordes
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

//            val rectangulo: Rectangulo = Rectangulo(ContextCompat.getColor(this,R.color.red), inicialWidth,inicialHeight).apply{
//                x=inicialx
//                y=inicialy
//            }


            val rectangulo = RectanguloBordes(ContextCompat.getColor(this,R.color.red), inicialWidth,inicialHeight).apply{
                /* x=inicialx
                y=inicialy */

                dimensiones.x=inicialx
                dimensiones.y=inicialy

                // significa que el color del borde es negro por defecto
                bordeColor=ContextCompat.getColor(this@MainActivity,R.color.black)
            }

            val arriba = findViewById<Button>(R.id.btn_arriba)
            val abajo = findViewById<Button>(R.id.btn_abajo)
            val izquierda = findViewById<Button>(R.id.btn_izquierda)
            val derecha = findViewById<Button>(R.id.btn_derecha)
            val tamano = findViewById<Button>(R.id.btn_tamano)
            val color = findViewById<Button>(R.id.btn_color)
            val colorBorde = findViewById<Button>(R.id.btn_colorBorde)


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

            colorBorde.setOnClickListener {
                //rectangulo.bordeColor = generarColorAleatorio()
                rectangulo.cambiarColorBorde(RectanguloBordes.ManejoColor.obtenerColorAleatorio()) // obtenerColorAleatorio() es una funcion de la clase ManejoColor de la clase RectanguloBordes (companion object)
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


    // ACTUALIZAR CAMBIOS EN LA VISTA DEL RECTANGULO (rectanguloVista)
    fun actualizarCambios(rectangulo: RectanguloBordes, rectanguloVista: View) {

        val drawable= GradientDrawable()  // GradientDrawable es una clase que permite dibujar un rectangulo con un color y un borde

        drawable.setColor(rectangulo.color)  // significa que el color del rectangulo es rojo por defecto
        drawable.setStroke(10,rectangulo.bordeColor)  // significa que el color del borde es negro por defecto

        //rectanguloVista.setBackgroundColor(rectangulo.color)

        rectanguloVista.background=drawable  // realiza el cambio de color del rectangulo y del borde

        //rectanguloVista.layoutParams.width=rectangulo.ancho  // significa que el ancho del rectangulo es 100 por defecto
        //rectanguloVista.layoutParams.height=rectangulo.alto  // significa que el alto del rectangulo es 100 por defecto

        rectanguloVista.layoutParams.width=rectangulo.dimensiones.ancho
        rectanguloVista.layoutParams.height=rectangulo.dimensiones.alto

        //rectanguloVista.x=rectangulo.x.toFloat()
        //rectanguloVista.y=rectangulo.y.toFloat()

        rectanguloVista.x=rectangulo.dimensiones.x.toFloat()
        rectanguloVista.y=rectangulo.dimensiones.y.toFloat()

        rectanguloVista.requestLayout()
    }
}
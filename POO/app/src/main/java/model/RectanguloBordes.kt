package model

import android.graphics.Color

// HERENCIA: Clase Hija (RectanguloBordes) y Clase Padre (Rectangulo)
class RectanguloBordes(color:Int, alto:Int, ancho:Int, var bordeColor: Int= Color.BLACK): Rectangulo(color,alto,ancho) {

    // CLASE NESTED
    class ManejoColor {

        // CLASE COMPANION OBJECT es una clase que se comporta como un objeto singleton y se puede acceder a sus miembros sin crear una instancia de la clase
        companion object {
            val ROJO = Color.RED
            val VERDE = Color.GREEN
            val AZUL = Color.BLUE
            val NEGRO = Color.BLACK

            fun obtenerColorAleatorio(): Int {
                val colores = listOf(ROJO, VERDE, AZUL, NEGRO)
                return colores.random()
            }
        }
    }

    fun cambiarColorBorde(nuevoColorBorde:Int) {
        bordeColor=nuevoColorBorde
    }
}
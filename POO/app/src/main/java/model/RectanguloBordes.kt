package model

import android.graphics.Color

class RectanguloBordes(color:Int, alto:Int, ancho:Int, var bordeColor: Int= Color.BLACK): Rectangulo(color,alto,ancho) {

    fun cambiarColorBorde(nuevoColorBorde:Int) {
        bordeColor=nuevoColorBorde
    }
}
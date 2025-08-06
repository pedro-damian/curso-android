package model

open class Rectangulo(var color: Int, var alto: Int, var ancho: Int) {


    var x: Int=0
    var y: Int=0

    fun moverArriba() {
        y-=10
    }

    fun moverAbajo() {
        y+=10
    }

    fun moverIzquierda() {
        x-=10
    }

    fun moverDerecha() {
        x+=10
    }

    fun cambiarTamaño(nuevoAncho: Int, nuevoAlto: Int) {
        alto= nuevoAlto
        ancho = nuevoAncho
    }
}
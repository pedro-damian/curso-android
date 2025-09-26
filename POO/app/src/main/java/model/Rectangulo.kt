package model

// Clase Padre (Rectangulo)
// open: significa que esta clase puede ser heredada por otra clase
open class Rectangulo(var color: Int, var alto: Int, var ancho: Int) {


    /*var x: Int=0
    var y: Int=0 */

    var dimensiones = MiDimension(0,0,ancho, alto)

    fun moverArriba() {
        // y-=10
        dimensiones.y-=10
    }

    fun moverAbajo() {
        // y+=10
        dimensiones.y+=10
    }

    fun moverIzquierda() {
        // x-=10
        dimensiones.x-=10
    }

    fun moverDerecha() {
        // x+=10
        dimensiones.x+=10
    }

    fun cambiarTamaño(nuevoAncho: Int, nuevoAlto: Int) {
        /* alto= nuevoAlto
        ancho = nuevoAncho */
        dimensiones.alto= nuevoAlto
        dimensiones.ancho = nuevoAncho

    }
}
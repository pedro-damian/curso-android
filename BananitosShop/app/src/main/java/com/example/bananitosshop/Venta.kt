package com.example.bananitosshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner

class Venta : AppCompatActivity() {

    lateinit var cboxLista : Spinner

    var datos = arrayOf("Zapatillas", "Polo", "Pantalon", "Medias", "Casacas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venta)

        cboxLista = findViewById(R.id.cbox_lista)


        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, datos)
        cboxLista.setAdapter(adapter)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun about() {
        val pantalla1 = Intent(this, AboutUs::class.java)
        startActivity(pantalla1)
        System.exit(0)
    }

    fun inicio() {
        val pantalla2 = Intent(this, MainActivity::class.java)
        startActivity(pantalla2)
        System.exit(0)
    }

    fun tienda() {
        val pantalla3 = Intent(this, Tienda::class.java)
        startActivity(pantalla3)
        System.exit(0)
    }

    fun caja() {
        val pantalla4 = Intent(this, Caja::class.java)
        startActivity(pantalla4)
        System.exit(0)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.inicio -> inicio()
            R.id.about -> about()
            R.id.tienda -> tienda()
            R.id.caja -> caja()

        }
        return super.onOptionsItemSelected(item)
    }
}
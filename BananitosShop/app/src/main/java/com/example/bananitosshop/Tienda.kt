package com.example.bananitosshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class Tienda : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)
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

    fun venta() {
        val pantalla3 = Intent(this, Venta::class.java)
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
            R.id.venta -> venta()
            R.id.caja -> caja()

        }
        return super.onOptionsItemSelected(item)
    }
}
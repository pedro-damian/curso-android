package com.example.lostrescerditos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.inicio -> inicio()
            R.id.about -> about()
            R.id.platos -> platos()
            R.id.bebidas -> bebidas()
            R.id.consumo -> consumo()
        }
        return super.onOptionsItemSelected(item)
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

    fun platos() {
        val pantalla3 = Intent(this, PedidosPlatos::class.java)
        startActivity(pantalla3)
        System.exit(0)
    }

    fun bebidas() {
        val pantalla4 = Intent(this, PedidosBebidas::class.java)
        startActivity(pantalla4)
        System.exit(0)
    }
    fun consumo() {
        val pantalla5 = Intent(this, PagoConsumo::class.java)
        startActivity(pantalla5)
        System.exit(0)
    }


}
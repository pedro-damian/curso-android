package com.example.applicationnotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity3 : AppCompatActivity() {
    lateinit var btnVolver : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        btnVolver = findViewById(R.id.btnVolver)

        btnVolver.setOnClickListener {
            val pantalla3 = Intent(this, MainActivity::class.java)
            startActivity(pantalla3)
            System.exit(0)
        }
    }

    fun llamar() {
        val pantalla1 = Intent(this, MainActivity2::class.java)
        startActivity(pantalla1)
        System.exit(0)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ayuda -> Toast.makeText(this, "Contactanos por Whatsapp", Toast.LENGTH_SHORT).show()
            R.id.quienes -> Toast.makeText(this, "Somos una Empresa con muchos años de experiencia",
                Toast.LENGTH_SHORT).show()
            R.id.mensaje -> Toast.makeText(this, "Todo Funciona Correctamente", Toast.LENGTH_SHORT).show()
            R.id.opcion -> llamar()
        }
        return super.onOptionsItemSelected(item)
    }
}
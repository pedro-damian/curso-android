package com.example.applicationnotas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    lateinit var btnRegresar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnRegresar = findViewById(R.id.btnRegresar)

        btnRegresar.setOnClickListener {
            val pantalla2 = Intent(this, MainActivity::class.java)
            startActivity(pantalla2)
            System.exit(0)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    fun llamar2() {
        val pantalla1 = Intent(this, MainActivity3::class.java)
        startActivity(pantalla1)
        System.exit(0)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ayuda -> Toast.makeText(this, "Contactanos por Whatsapp", Toast.LENGTH_SHORT).show()
            R.id.quienes -> Toast.makeText(this, "Somos una Empresa con muchos años de experiencia",
                Toast.LENGTH_SHORT).show()
            R.id.mensaje -> Toast.makeText(this, "Todo Funciona Correctamente", Toast.LENGTH_SHORT).show()

            R.id.ventana3 -> llamar2()
        }
        return super.onOptionsItemSelected(item)
    }
}
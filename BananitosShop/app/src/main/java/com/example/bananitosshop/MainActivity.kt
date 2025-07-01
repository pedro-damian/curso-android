package com.example.bananitosshop

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnContinuar: Button
    lateinit var btnCerrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnContinuar = findViewById(R.id.btn_continuar)
        btnCerrar = findViewById(R.id.btn_cerrar)

        btnContinuar.setOnClickListener {
            val pantalla1 = Intent(this, Tienda::class.java)
            startActivity(pantalla1)
            System.exit(0)
        }

        btnCerrar.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder
                .setMessage("Fin de la aplicacion")
                .setTitle("Cerrar aplicacion")
                // crea el boton SI confirma salir de la aplicacion
                .setPositiveButton(android.R.string.yes){dialog, which -> Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()
                    System.exit(0) }
                // crea el boton NO se queda en la aplicacion
                .setNegativeButton(android.R.string.no){dialog, which -> Toast.makeText(applicationContext, "Cancelado", Toast.LENGTH_SHORT).show()}
            // crea el mensaje del dialogo
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}
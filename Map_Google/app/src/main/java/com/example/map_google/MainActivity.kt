package com.example.map_google

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var btnirmaps: Button
    lateinit var btnCerrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnirmaps = findViewById(R.id.btnirmaps)
        btnCerrar = findViewById(R.id.btncerrar)

        btnirmaps.setOnClickListener {
            //val gmmIntentUri = Uri.parse("geo:0,0?q=-12.066877, -77.035721(IDAT-Lima Centro)")
            //val gmmIntentUri = Uri.parse("geo:0,0?q=-14.087493686340313, -75.76572827490355(Huacachina)")
            val gmmIntentUri = Uri.parse("geo:0,0?q=-13.163225249955481, -72.54577669455493(MachuPicchu)")
            //val gmmIntentUri = Uri.parse("geo:37.7749,-122.4194")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            /* mapIntent.resolveActivity(packageManager)?.let {
                startActivity(mapIntent)
            } */
            startActivity(mapIntent)
        }

        btnCerrar.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder
                .setMessage("Fin de la aplicacion")
                .setTitle("Cerrar aplicacion")
                .setPositiveButton(android.R.string.yes){dialog, which -> Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()
                    System.exit(0) }
                .setNegativeButton(android.R.string.no){dialog, which -> Toast.makeText(applicationContext, "Cancelado", Toast.LENGTH_SHORT).show()}
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}
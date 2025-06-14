package com.example.ejercicio2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var rbGarfield: RadioButton
    lateinit var rbSimios: RadioButton
    lateinit var rbBarbie: RadioButton
    lateinit var rbGuerra: RadioButton
    lateinit var rbVaguito: RadioButton
    lateinit var txtEntradas: EditText
    lateinit var txtCosto: EditText
    lateinit var cbBebida: CheckBox
    lateinit var cbCanchita: CheckBox
    lateinit var cbHamburguesa: CheckBox
    lateinit var lbResultado: TextView
    lateinit var btnNuevo: Button
    lateinit var btnCalcular: Button
    lateinit var btnCerrar: Button

    var precioBebida = 7.0
    var precioCanchita = 25.0
    var precioHamburguesa = 15.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rbGarfield = findViewById(R.id.rb_garfield)
        rbSimios = findViewById(R.id.rb_simios)
        rbBarbie = findViewById(R.id.rb_barbie)
        rbGuerra = findViewById(R.id.rb_guerra)
        rbVaguito = findViewById(R.id.rb_vaguito)
        txtEntradas = findViewById(R.id.txt_entradas)
        txtCosto = findViewById(R.id.txt_costo)
        cbBebida = findViewById(R.id.cb_bebida)
        cbCanchita = findViewById(R.id.cb_canchita)
        cbHamburguesa = findViewById(R.id.cb_hamburguesa)
        lbResultado = findViewById(R.id.lb_resultado)
        btnNuevo = findViewById(R.id.btn_nuevo)
        btnCalcular = findViewById(R.id.btn_calcular)
        btnCerrar = findViewById(R.id.btn_cerrar)

        btnNuevo.setOnClickListener { nuevo() }
        btnCerrar.setOnClickListener { cerrar() }
        btnCalcular.setOnClickListener { calcular() }

    }


    fun calcular() {

        // Obtener entradas y costo unitario
        val entradas = txtEntradas.text.toString().toInt()
        val costoUnitario = txtCosto.text.toString().toDouble()

        // Determinar descuento según la película
        var descuento = 0.0
        if (rbGarfield.isChecked) {
            descuento = 0.10
        }
        else if (rbSimios.isChecked) {
            descuento = 0.05
        }
        else if (rbBarbie.isChecked) {
            descuento = 0.25
        }
        else if (rbGuerra.isChecked) {
            descuento = 0.10
        }
        else if (rbVaguito.isChecked) {
            descuento = 0.01
        }

        val costoSinDescuento = entradas * costoUnitario
        val montoDescuento = costoSinDescuento * descuento
        val costoEntradas = costoSinDescuento - montoDescuento

        // Calcular costo de alimentos
        var costoAlimentos = 0.0
        if (cbBebida.isChecked) {
            costoAlimentos += precioBebida
        }
        if (cbCanchita.isChecked) {
            costoAlimentos += precioCanchita
        }
        if (cbHamburguesa.isChecked) {
            costoAlimentos += precioHamburguesa
        }

        val total = costoEntradas + costoAlimentos

        lbResultado.text = "Total: S/ ${total} - Subtotal: S/. ${costoSinDescuento + costoAlimentos} - S/. Descuento: ${montoDescuento} - Costo Alimentos: S/. ${costoAlimentos}"
    }


    fun nuevo() {
        rbGarfield.setChecked(false)
        rbSimios.setChecked(false)
        rbBarbie.setChecked(false)
        rbGuerra.setChecked(false)
        rbVaguito.setChecked(false)
        txtEntradas.setText("")
        txtCosto.setText("")
        cbBebida.setChecked(false)
        cbCanchita.setChecked(false)
        cbHamburguesa.setChecked(false)
        lbResultado.text = ""
        txtEntradas.requestFocus()
    }

    fun cerrar(){
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
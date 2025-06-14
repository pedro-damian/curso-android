package com.example.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var cbCeviche: CheckBox
    lateinit var cbArrozPato: CheckBox
    lateinit var cbParihuela: CheckBox
    lateinit var txtCeviche: EditText
    lateinit var txtArrozPato: EditText
    lateinit var txtParihuela: EditText

    lateinit var rbVip: RadioButton
    lateinit var rbEmpresarial: RadioButton
    lateinit var rbFamiliar: RadioButton
    lateinit var rbNormal: RadioButton
    lateinit var lbResultado: TextView

    lateinit var btnNuevo: Button
    lateinit var btnCalcular: Button
    lateinit var btnCerrar: Button

    val precioCeviche = 40.0
    val precioArrozPato = 50.0
    val precioParihuela = 60.0
    val IGV = 0.18


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cbCeviche = findViewById(R.id.cb_ceviche)
        cbArrozPato = findViewById(R.id.cb_arroz_pato)
        cbParihuela = findViewById(R.id.cb_parihuela)
        txtCeviche = findViewById(R.id.et_ceviche)
        txtArrozPato = findViewById(R.id.et_arroz_pato)
        txtParihuela = findViewById(R.id.et_parihuela)

        rbVip = findViewById(R.id.rb_vip)
        rbEmpresarial = findViewById(R.id.rb_empresarial)
        rbFamiliar = findViewById(R.id.rb_familiar)
        rbNormal = findViewById(R.id.rb_normal)
        lbResultado = findViewById(R.id.tv_resultado)

        btnNuevo = findViewById(R.id.btn_nuevo)
        btnCalcular = findViewById(R.id.btn_calcular)
        btnCerrar = findViewById(R.id.btn_cerrar)

        btnNuevo.setOnClickListener { nuevo() }
        btnCerrar.setOnClickListener { cerrar() }
        btnCalcular.setOnClickListener { calcular() }


    }

    fun calcular() {

        var consumo = 0.0
        // Calcular consumo por platos
        if (cbCeviche.isChecked) {
            val cantidad = txtCeviche.text.toString().toDouble()
            consumo += cantidad * precioCeviche
        }
        if (cbArrozPato.isChecked) {
            val cantidad = txtArrozPato.text.toString().toDouble()
            consumo += cantidad * precioArrozPato
        }
        if (cbParihuela.isChecked) {
            val cantidad = txtParihuela.text.toString().toDouble()
            consumo += cantidad * precioParihuela
        }

        var costoPresentacion = 0.0
        if (rbVip.isChecked) {
            costoPresentacion = 25.0
        } else if (rbEmpresarial.isChecked) {
            costoPresentacion = 45.0
        } else if (rbFamiliar.isChecked) {
            costoPresentacion = 20.0
        } else if (rbNormal.isChecked) {
            costoPresentacion = 5.0
        }

        val igv = consumo * IGV
        val total = consumo + igv + costoPresentacion

        lbResultado.text = "Total: S/. ${total} - IGV: ${String.format("%.1f", igv)} - Consumo: S/. ${consumo} - Costo de Mesa: S/. ${costoPresentacion}"

    }


    fun nuevo() {
        cbCeviche.setChecked(false)
        cbArrozPato.setChecked(false)
        cbParihuela.setChecked(false)
        rbVip.setChecked(false)
        rbEmpresarial.setChecked(false)
        rbFamiliar.setChecked(false)
        rbNormal.setChecked(false)
        txtCeviche.setText("")
        txtArrozPato.setText("")
        txtParihuela.setText("")
        lbResultado.text = ""
        txtCeviche.requestFocus()
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
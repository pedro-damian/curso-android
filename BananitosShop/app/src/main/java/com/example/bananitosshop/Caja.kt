package com.example.bananitosshop

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class Caja : AppCompatActivity() {

    lateinit var etFecha: EditText
    lateinit var etSaldo: EditText
    lateinit var cbRetiros: CheckBox
    lateinit var etRetiros: EditText
    lateinit var cbVentas: CheckBox
    lateinit var etVentas: EditText
    lateinit var cbCreditos: CheckBox
    lateinit var etCreditos: EditText
    lateinit var cbAlquiler: CheckBox
    lateinit var etAlquiler: EditText
    lateinit var cbLuz: CheckBox
    lateinit var etLuz: EditText
    lateinit var cbAgua: CheckBox
    lateinit var etAgua: EditText
    lateinit var cbImpuestos: CheckBox
    lateinit var etImpuestos: EditText
    lateinit var cbEmpleados: CheckBox
    lateinit var etEmpleados: EditText
    lateinit var cbOtros: CheckBox
    lateinit var etOtros: EditText
    lateinit var btnNuevo: Button
    lateinit var btnCalcular: Button
    lateinit var tvResultado: TextView
    lateinit var dialogBuilder: AlertDialog.Builder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_caja)

        etFecha = findViewById(R.id.etFecha)
        etSaldo = findViewById(R.id.etSaldo)
        cbRetiros = findViewById(R.id.cbRetiros)
        etRetiros = findViewById(R.id.etRetiros)
        cbVentas = findViewById(R.id.cbVentas)
        etVentas = findViewById(R.id.etVentas)
        cbCreditos = findViewById(R.id.cbCreditos)
        etCreditos = findViewById(R.id.etCreditos)
        cbAlquiler = findViewById(R.id.cbAlquiler)
        etAlquiler = findViewById(R.id.etAlquiler)
        cbLuz = findViewById(R.id.cbLuz)
        etLuz = findViewById(R.id.etLuz)
        cbAgua = findViewById(R.id.cbAgua)
        etAgua = findViewById(R.id.etAgua)
        cbImpuestos = findViewById(R.id.cbImpuestos)
        etImpuestos = findViewById(R.id.etImpuestos)
        cbEmpleados = findViewById(R.id.cbEmpleados)
        etEmpleados = findViewById(R.id.etEmpleados)
        cbOtros = findViewById(R.id.cbOtros)
        etOtros = findViewById(R.id.etOtros)
        btnNuevo = findViewById(R.id.btnNuevo)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)
        dialogBuilder = AlertDialog.Builder(this).setTitle("Error de datos")


        cbRetiros.setOnCheckedChangeListener { _, isChecked -> etRetiros.isEnabled = isChecked }
        cbVentas.setOnCheckedChangeListener { _, isChecked -> etVentas.isEnabled = isChecked }
        cbCreditos.setOnCheckedChangeListener { _, isChecked -> etCreditos.isEnabled = isChecked }
        cbAlquiler.setOnCheckedChangeListener { _, isChecked -> etAlquiler.isEnabled = isChecked }
        cbLuz.setOnCheckedChangeListener { _, isChecked -> etLuz.isEnabled = isChecked }
        cbAgua.setOnCheckedChangeListener { _, isChecked -> etAgua.isEnabled = isChecked }
        cbImpuestos.setOnCheckedChangeListener { _, isChecked -> etImpuestos.isEnabled = isChecked }
        cbEmpleados.setOnCheckedChangeListener { _, isChecked -> etEmpleados.isEnabled = isChecked }
        cbOtros.setOnCheckedChangeListener { _, isChecked -> etOtros.isEnabled = isChecked }

        btnNuevo.setOnClickListener { nuevo() }
        btnCalcular.setOnClickListener { calcular() }

    }

    fun calcular () {
        val fecha = etFecha.text.toString()
        val saldoInicial = etSaldo.text.toString().toDouble()

        var totalIngresos = 0.0
        if (cbRetiros.isChecked) {
            val monto = etRetiros.text.toString().toDouble()
            totalIngresos += monto
        }
        if (cbVentas.isChecked) {
            val monto = etVentas.text.toString().toDouble()
            totalIngresos += monto
        }
        if (cbCreditos.isChecked) {
            val monto = etCreditos.text.toString().toDouble()
            totalIngresos += monto
        }

        var totalGastos = 0.0
        if (cbAlquiler.isChecked) {
            val monto = etAlquiler.text.toString().toDouble()
            totalGastos += monto
        }
        if (cbLuz.isChecked) {
            val monto = etLuz.text.toString().toDouble()
            totalGastos += monto
        }
        if (cbAgua.isChecked) {
            val monto = etAgua.text.toString().toDouble()
            totalGastos += monto
        }
        if (cbImpuestos.isChecked) {
            val monto = etImpuestos.text.toString().toDouble()
            totalGastos += monto
        }
        if (cbEmpleados.isChecked) {
            val monto = etEmpleados.text.toString().toDouble()
            totalGastos += monto
        }
        if (cbOtros.isChecked) {
            val monto = etOtros.text.toString().toDouble()
            totalGastos += monto
        }

        var saldoFinal = saldoInicial + totalIngresos - totalGastos

        tvResultado.text = """
            El saldo Inicial es: ${saldoInicial}
            Total Ingresos: ${totalIngresos}
            Total Gastos ${totalGastos}
            El saldo final es: ${String.format("%.1f", saldoFinal)}
            """.trimIndent()
    }

    fun nuevo() {
        etFecha.setText("")
        etSaldo.setText("")
        cbRetiros.isChecked = false
        etRetiros.setText("")
        cbVentas.isChecked = false
        etVentas.setText("")
        cbCreditos.isChecked = false
        etCreditos.setText("")
        cbAlquiler.isChecked = false
        etAlquiler.setText("")
        cbLuz.isChecked = false
        etLuz.setText("")
        cbAgua.isChecked = false
        etAgua.setText("")
        cbImpuestos.isChecked = false
        etImpuestos.setText("")
        cbEmpleados.isChecked = false
        etEmpleados.setText("")
        cbOtros.isChecked = false
        etOtros.setText("")
        tvResultado.text = ""
        etFecha.requestFocus()
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

    fun tienda() {
        val pantalla4 = Intent(this, Tienda::class.java)
        startActivity(pantalla4)
        System.exit(0)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.inicio -> inicio()
            R.id.about -> about()
            R.id.venta -> venta()
            R.id.tienda -> tienda()
        }
        return super.onOptionsItemSelected(item)
    }

}
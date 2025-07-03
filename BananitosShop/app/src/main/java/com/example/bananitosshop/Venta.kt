package com.example.bananitosshop

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class Venta : AppCompatActivity() {

    lateinit var cboxLista : Spinner
    lateinit var etNombre : EditText
    lateinit var etRUC : EditText
    lateinit var etFecha : EditText
    lateinit var etComprobante: EditText
    lateinit var etCantidad : EditText

    lateinit var rbDescuento10 : RadioButton
    lateinit var rbDescuento20 : RadioButton
    lateinit var btnNuevo : Button
    lateinit var btnCalcular : Button
    lateinit var tvResultado: TextView
    lateinit var dialogBuilder: AlertDialog.Builder

    var datos = arrayOf("Seleccione un articulo","Zapatillas S/.100", "Polo S/.30", "Pantalon S/.120", "Medias S/.15", "Casacas S/.180")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venta)

        etNombre = findViewById(R.id.etNombre)
        etRUC = findViewById(R.id.etRUC)
        etFecha = findViewById(R.id.etFecha)
        etComprobante = findViewById(R.id.etComprobante)
        etCantidad = findViewById(R.id.etCantidad)
        rbDescuento10 = findViewById(R.id.rbDescuento10)
        rbDescuento20 = findViewById(R.id.rbDescuento20)
        btnNuevo = findViewById(R.id.btnNuevo)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)
        cboxLista = findViewById(R.id.cbox_lista)
        dialogBuilder = AlertDialog.Builder(this).setTitle("Error de datos")

        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, datos)
        cboxLista.setAdapter(adapter)

        btnNuevo.setOnClickListener { nuevo() }
        btnCalcular.setOnClickListener { calcular() }

    }

    fun calcular() {
        val nombre = etNombre.text.toString()
        val ruc = etRUC.text.toString()
        val fecha = etFecha.text.toString()
        val comprobante = etComprobante.text.toString()
        val cantidad = etCantidad.text.toString().toInt()
        val producto = cboxLista.selectedItem.toString()

        var precioUnitario = 0.0
        if (producto == "Zapatillas S/.100") {
            precioUnitario = 100.0
        } else if (producto == "Polo S/.30") {
            precioUnitario = 30.0
        } else if (producto == "Pantalon S/.120") {
            precioUnitario = 120.0
        } else if (producto == "Medias S/.15") {
            precioUnitario = 15.0
        } else if (producto == "Casacas S/.180") {
            precioUnitario = 180.0
        }

        val subtotal = cantidad * precioUnitario

        var descuento = 0.0
        if (rbDescuento10.isChecked) {
            descuento = 0.10
        } else {
            descuento = 0.20
        }

        val montoDescuento = subtotal * descuento
        val total = subtotal - montoDescuento

        tvResultado.text = """
            Cliente: $nombre
            RUC: $ruc
            Fecha: $fecha
            Comprobante: $comprobante
            Cantidad: $cantidad
            Precio: S/ ${String.format("%.1f", precioUnitario)}
            Subtotal: S/ ${String.format("%.1f", subtotal)}
            Descuento: S/ ${String.format("%.1f", montoDescuento)}
            Total a pagar: S/ ${String.format("%.1f", total)}
        """.trimIndent()

        Toast.makeText(applicationContext, "¡Venta Registrada!", Toast.LENGTH_SHORT).show()
    }


    fun nuevo () {
        etNombre.setText("")
        etRUC.setText("")
        etFecha.setText("")
        etComprobante.setText("")
        etCantidad.setText("")
        rbDescuento10.isChecked = false
        rbDescuento20.isChecked = false
        cboxLista.setSelection(0)
        tvResultado.text = ""
        etNombre.requestFocus()
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
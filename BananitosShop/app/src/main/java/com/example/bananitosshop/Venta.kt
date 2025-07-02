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
    lateinit var etPrecio: EditText
    lateinit var rbDescuento10 : RadioButton
    lateinit var rbDescuento20 : RadioButton
    lateinit var btnNuevo : Button
    lateinit var btnCalcular : Button
    lateinit var tvResultado: TextView
    lateinit var dialogBuilder: AlertDialog.Builder

    var datos = arrayOf("Zapatillas", "Polo", "Pantalon", "Medias", "Casacas")
    var Zapatillas = 100.0
    var Polo = 30.0
    var Pantalon = 120.0
    var Medias = 15.0
    var Casacas = 180.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venta)

        etNombre = findViewById(R.id.etNombre)
        etRUC = findViewById(R.id.etRUC)
        etFecha = findViewById(R.id.etFecha)
        etComprobante = findViewById(R.id.etComprobante)
        etCantidad = findViewById(R.id.etCantidad)
        etPrecio = findViewById(R.id.etPrecio)
        rbDescuento10 = findViewById(R.id.rbDescuento10)
        rbDescuento20 = findViewById(R.id.rbDescuento20)
        btnNuevo = findViewById(R.id.btnNuevo)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)
        cboxLista = findViewById(R.id.cbox_lista)
        dialogBuilder = AlertDialog.Builder(this).setTitle("Error de datos")

        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, datos)
        cboxLista.setAdapter(adapter)


        // Actualizar precio al seleccionar producto
        cboxLista.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val producto = datos[position]
                val precio = when (producto) {
                    "Zapatillas" -> 100.0
                    "Polo" -> 30.0
                    "Pantalón" -> 80.0
                    "Medias" -> 10.0
                    "Casacas" -> 150.0
                    else -> 0.0
                }
                etPrecio.setText(String.format("%.1f", precio))
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                etPrecio.setText("0.0")
            }
        }


        btnNuevo.setOnClickListener { nuevo() }
        btnCalcular.setOnClickListener { calcular() }

    }

    fun nuevo () {
        etNombre.setText("")
        etRUC.setText("")
        etFecha.setText("")
        etComprobante.setText("")
        etCantidad.setText("")
        etPrecio.setText("0.0")
        rbDescuento10.isChecked = false
        rbDescuento20.isChecked = false
        cboxLista.setSelection(0)
        tvResultado.text = "Total a pagar: S/ 0.00"
        etNombre.requestFocus()
    }


    fun calcular () {

        // Obtener datos
        val nombre = etNombre.text.toString()
        val ruc = etRUC.text.toString()
        val fecha = etFecha.text.toString()
        val comprobante = etComprobante.text.toString()
        val producto = cboxLista.selectedItem.toString()
        var precio = 0.0
        val cantidad = etCantidad.text.toString().toInt()

        //var opcion: String = cboxLista.selectedItem.toString()
        if(producto.equals("Zapatillas")){
            precio = 100.0
            // etPrecio.setText(precio.toString())
            etPrecio.setText(String.format("%.1f", precio))
        } else if (producto == "Polo") {
            precio = 30.0
            etPrecio.setText(String.format("%.1f", precio))
        } else if (producto == "Pantalon") {
            precio = 80.0
            etPrecio.setText(String.format("%.1f", precio))
        } else if (producto == "Medias") {
            precio = 10.0
            etPrecio.setText(String.format("%.1f", precio))
        } else if (producto == "Casacas") {
            precio = 150.0
            etPrecio.setText(String.format("%.1f", precio))
        }

        // Determinar descuento
        var descuento = 0.0
        if (rbDescuento10.isChecked) descuento = 0.10
        else if (rbDescuento20.isChecked) descuento = 0.20

        // Calcular total
        val subtotal = precio * cantidad
        val montoDescuento = subtotal * descuento
        val total = subtotal - montoDescuento

        // Formatear números

        tvResultado.text = """
            Detalles de la Venta:
            Cliente: $nombre
            RUC: $ruc
            Fecha: $fecha
            Comprobante: $comprobante
            Cantidad: $cantidad
            Precio unitario: S/ ${String.format("%.1f", precio)}
            Subtotal: S/ ${String.format("%.1f", subtotal)}
            Descuento (${(descuento * 100).toInt()}%): S/ ${String.format("%.1f", montoDescuento)}
            Total a pagar: S/ ${String.format("%.1f", total)}
        """.trimIndent()

        // Mostrar Toast
        Toast.makeText(this, "¡Venta Registrada!", Toast.LENGTH_SHORT).show()
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
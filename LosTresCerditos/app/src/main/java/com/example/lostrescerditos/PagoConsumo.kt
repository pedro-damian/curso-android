package com.example.lostrescerditos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*

class PagoConsumo : AppCompatActivity() {

    lateinit var etPedido: EditText
    lateinit var etComprobante: EditText
    lateinit var etRUC: EditText // Usado para RUC
    lateinit var etFecha: EditText
    lateinit var etCliente: EditText
    lateinit var etImporte: EditText
    lateinit var cbDescuento: CheckBox
    lateinit var btnNuevo: Button
    lateinit var btnCalcular: Button
    lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_consumo)

        etPedido = findViewById(R.id.etPedido)
        etComprobante = findViewById(R.id.etComprobante)
        etRUC = findViewById(R.id.etRUC)
        etFecha = findViewById(R.id.etFecha)
        etCliente = findViewById(R.id.etCliente)
        etImporte = findViewById(R.id.etImporte)
        cbDescuento = findViewById(R.id.cbDescuento)
        btnNuevo = findViewById(R.id.btnNuevo)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        btnNuevo.setOnClickListener { nuevo() }
        btnCalcular.setOnClickListener { calcular() }
    }

    fun calcular() {
        val pedido = etPedido.text.toString()
        val comprobante = etComprobante.text.toString()
        val cliente = etCliente.text.toString()
        val importe = etImporte.text.toString().toDouble()

        val igv = importe * 0.18
        val descuento = if (cbDescuento.isChecked) importe * 0.10 else 0.0
        val total = importe - descuento + igv

        tvResultado.text = """
           N° Pedido: ${pedido}
           N° Comprobante: ${comprobante}
           Cliente: ${cliente}
           IGV (18%): ${igv}
           Descuento (10%): ${descuento}
           Total a pagar: ${total}
        """.trimIndent()

        Toast.makeText(applicationContext, "¡Pago Registrado!", Toast.LENGTH_SHORT).show()
    }


    fun nuevo(){
        etPedido.setText("")
        etComprobante.setText("")
        etRUC.setText("")
        etFecha.setText("")
        etCliente.setText("")
        etImporte.setText("")
        cbDescuento.isChecked = false
        tvResultado.text = ""
        etPedido.requestFocus()
    }

    override fun onCreateOptionsMenu(menu: android.view.Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.inicio -> inicio()
            R.id.menu -> menu()
            R.id.platos -> platos()
            R.id.bebidas -> bebidas()
            R.id.about -> about()
        }
        return super.onOptionsItemSelected(item)
    }

    fun menu() {
        val pantalla1 = Intent(this, Menu::class.java)
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
    fun about() {
        val pantalla5 = Intent(this, AboutUs::class.java)
        startActivity(pantalla5)
        System.exit(0)
    }
}
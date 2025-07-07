package com.example.lostrescerditos

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*

class PedidosBebidas : AppCompatActivity() {

    lateinit var etPedido: EditText
    lateinit var etMesa: EditText
    lateinit var etFecha: EditText
    lateinit var etCliente: EditText
    lateinit var cboxMozos: Spinner
    lateinit var cbGaseosa: CheckBox
    lateinit var etGaseosa: EditText
    lateinit var cbChicha: CheckBox
    lateinit var etChicha: EditText
    lateinit var cbLimonada: CheckBox
    lateinit var etLimonada: EditText
    lateinit var btnNuevo: Button
    lateinit var btnCalcular: Button
    lateinit var tvResultado: TextView
    lateinit var dialogBuilder: AlertDialog.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos_bebidas)

        etPedido = findViewById(R.id.etPedido)
        etMesa = findViewById(R.id.etRUC)
        etFecha = findViewById(R.id.etFecha)
        etCliente = findViewById(R.id.etCliente)
        cboxMozos = findViewById(R.id.cbox_mozos)
        cbGaseosa = findViewById(R.id.cbGaseosa)
        etGaseosa = findViewById(R.id.etGaseosa)
        cbChicha = findViewById(R.id.cbChicha)
        etChicha = findViewById(R.id.etChicha)
        cbLimonada = findViewById(R.id.cbLimonada)
        etLimonada = findViewById(R.id.etLimonada)
        btnNuevo = findViewById(R.id.btnNuevo)
        btnCalcular = findViewById(R.id.btnCalcular)
        tvResultado = findViewById(R.id.tvResultado)

        // variable mozos que alamacena el arreglo de los mozos
        val mozos = arrayOf("Seleccione un mozo", "Juan Pérez", "María López", "Carlos Gómez", "Ana Martínez", "Luis Torres")
        // se crea una adaptador que va tomar los valores de el arreglo mozos y mostrarlos en el spinner
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mozos)
        // vincula el adaptador con el elemento del spinner en la interfaz para mostrarlos
        cboxMozos.setAdapter(adapter)

        // cuando el usuario marca el checkbox el campo de entradas se habilite y cuando lo desmarca se deshabilite borra los valores
        cbGaseosa.setOnCheckedChangeListener { _, isChecked -> etGaseosa.isEnabled = isChecked
            etGaseosa.setText(if (!isChecked) "" else etGaseosa.text.toString()) }
        cbChicha.setOnCheckedChangeListener { _, isChecked -> etChicha.isEnabled = isChecked
            etChicha.setText(if (!isChecked) "" else etChicha.text.toString())}
        cbLimonada.setOnCheckedChangeListener { _, isChecked -> etLimonada.isEnabled = isChecked
            etLimonada.setText(if (!isChecked) "" else etLimonada.text.toString())}

        // llaman alas funciones nuevo y calcular
        btnNuevo.setOnClickListener { nuevo() }
        btnCalcular.setOnClickListener { calcular() }
    }

    fun calcular(){
        // se crean variables que recibiran los datos ingresados o seleccionados en la interfaz
        val pedido = etPedido.text.toString()
        val mesa = etMesa.text.toString()
        val fecha = etFecha.text.toString()
        val cliente = etCliente.text.toString()
        val mozo = cboxMozos.selectedItem.toString()


        var total = 0.0
        // condicional que evalua si el checkbox esta marcado
        if (cbGaseosa.isChecked) {
            // se crea una variable que almacena el valor ingresado en el campo de entrada
            val cantidad = etGaseosa.text.toString().toInt()
            // calcula subtotal
            val subtotal = cantidad * 20.0
            // la variable total va sumar y acumular subtotal
            total += subtotal
        }
        if (cbChicha.isChecked) {
            val cantidad = etChicha.text.toString().toInt()
            val subtotal = cantidad * 15.0
            total += subtotal
        }
        if (cbLimonada.isChecked) {
            val cantidad = etLimonada.text.toString().toInt()
            val subtotal = cantidad * 12.0
            total += subtotal
        }

        // muestra los detalles en una cadena multilinea
        tvResultado.text = """
            N° Pedido: ${pedido}
            N° Mesa: ${mesa}
            Fecha: ${fecha}
            Cliente: ${cliente}
            Mozo: ${mozo}
            Total a Pagar: ${total}
        """.trimIndent()

        // mensaje de Toast Pedido de Bebida Registrado
        Toast.makeText(applicationContext, "¡Pedido de Bebida Registrado!", Toast.LENGTH_SHORT).show()
    }

    // reinicia los elementos de la interfaz
    fun nuevo() {
        etPedido.setText("")
        etMesa.setText("")
        etFecha.setText("")
        etCliente.setText("")
        cboxMozos.setSelection(0)
        cbGaseosa.isChecked = false
        etGaseosa.setText("")
        etGaseosa.isEnabled = false
        cbChicha.isChecked = false
        etChicha.setText("")
        etChicha.isEnabled = false
        cbLimonada.isChecked = false
        etLimonada.setText("")
        etLimonada.isEnabled = false
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
            R.id.about -> about()
            R.id.consumo -> consumo()
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

    fun about() {
        val pantalla4 = Intent(this, AboutUs::class.java)
        startActivity(pantalla4)
        System.exit(0)
    }
    fun consumo() {
        val pantalla5 = Intent(this, PagoConsumo::class.java)
        startActivity(pantalla5)
        System.exit(0)
    }
}
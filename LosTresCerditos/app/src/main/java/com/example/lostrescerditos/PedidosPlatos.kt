package com.example.lostrescerditos

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.*

class PedidosPlatos : AppCompatActivity() {

    lateinit var etPedido: EditText
    lateinit var etMesa: EditText
    lateinit var etFecha: EditText
    lateinit var etCliente: EditText
    lateinit var cboxMozos: Spinner
    lateinit var cbCeviche: CheckBox
    lateinit var etCeviche: EditText
    lateinit var cbTallarin: CheckBox
    lateinit var etTallarin: EditText
    lateinit var cbArroz: CheckBox
    lateinit var etArroz: EditText
    lateinit var btnNuevo: Button
    lateinit var btnCalcular: Button
    lateinit var tvResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedidos_platos)

        etPedido = findViewById(R.id.etPedido)
        etMesa = findViewById(R.id.etRUC)
        etFecha = findViewById(R.id.etFecha)
        etCliente = findViewById(R.id.etCliente)
        cboxMozos = findViewById(R.id.cbox_mozos)
        cbCeviche = findViewById(R.id.cbCeviche)
        etCeviche = findViewById(R.id.etCeviche)
        cbTallarin = findViewById(R.id.cbTallarin)
        etTallarin = findViewById(R.id.etTallarin)
        cbArroz = findViewById(R.id.cbArroz)
        etArroz = findViewById(R.id.etArroz)
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
        cbCeviche.setOnCheckedChangeListener { _, isChecked -> etCeviche.isEnabled = isChecked
            etCeviche.setText(if (!isChecked) "" else etCeviche.text.toString()) }
        cbTallarin.setOnCheckedChangeListener { _, isChecked -> etTallarin.isEnabled = isChecked
            etTallarin.setText(if (!isChecked) "" else etTallarin.text.toString())}
        cbArroz.setOnCheckedChangeListener { _, isChecked -> etArroz.isEnabled = isChecked
            etArroz.setText(if (!isChecked) "" else etArroz.text.toString())}

        // llama a las funciones
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
        if (cbCeviche.isChecked) {
            // se crea una variable que almacena el valor ingresado en el campo de entrada
            val cantidad = etCeviche.text.toString().toInt()
            // calcula subtotal
            val subtotal = cantidad * 20.0
            // la variable total va sumar y acumular subtotal
            total += subtotal
        }
        if (cbTallarin.isChecked) {
            val cantidad = etTallarin.text.toString().toInt()
            val subtotal = cantidad * 15.0
            total += subtotal
        }
        if (cbArroz.isChecked) {
            val cantidad = etArroz.text.toString().toInt()
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

        // mensaje de Toast Pedido de Plato Registrado
        Toast.makeText(applicationContext, "¡Pedido de Plato Registrado!", Toast.LENGTH_SHORT).show()
    }

    // reinicia los elementos de la interfaz
    fun nuevo() {
        etPedido.setText("")
        etMesa.setText("")
        etFecha.setText("")
        etCliente.setText("")
        cboxMozos.setSelection(0)
        cbCeviche.isChecked = false
        etCeviche.setText("")
        etCeviche.isEnabled = false
        cbTallarin.isChecked = false
        etTallarin.setText("")
        etTallarin.isEnabled = false
        cbArroz.isChecked = false
        etArroz.setText("")
        etArroz.isEnabled = false
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
            R.id.about -> about()
            R.id.bebidas -> bebidas()
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

    fun about() {
        val pantalla3 = Intent(this, AboutUs::class.java)
        startActivity(pantalla3)
        System.exit(0)
    }

    fun bebidas() {
        val pantalla4 = Intent(this, PedidosBebidas::class.java)
        startActivity(pantalla4)
        System.exit(0)
    }
    fun consumo() {
        val pantalla5 = Intent(this, PagoConsumo::class.java)
        startActivity(pantalla5)
        System.exit(0)
    }
}
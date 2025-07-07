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

    // variable datos que alamacena el arreglo de los articulos
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

//      se crea una adaptador que va tomar los valores de el arreglo datos y mostrarlos en el spinner
        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, datos)
//        vincula el adaptador con el elemento del spinner en la interfaz para mostrarlos
        cboxLista.setAdapter(adapter)

        // la variable btnNuevo y btncalcular llama a la funcion nuevo y clacular respectivamente
        btnNuevo.setOnClickListener { nuevo() }
        btnCalcular.setOnClickListener { calcular() }

    }

    fun calcular() {
        // se crean variables que recibiran los datos ingresados o seleccionados en la interfaz
        val nombre = etNombre.text.toString()
        val ruc = etRUC.text.toString()
        val fecha = etFecha.text.toString()
        val comprobante = etComprobante.text.toString()
        val cantidad = etCantidad.text.toString().toInt()
        val producto = cboxLista.selectedItem.toString()

//      se creo una variable preciounitario que almacena el precio del producto elegido
        var precioUnitario = 0.0
        // evalua si el producto elegido en la lista desplegable de la interfaz es igual a la condicion
        if (producto == "Zapatillas S/.100") {
            precioUnitario = 100.0  // si la condicion es verdadera establece el precio
        } else if (producto == "Polo S/.30") {
            precioUnitario = 30.0
        } else if (producto == "Pantalon S/.120") {
            precioUnitario = 120.0
        } else if (producto == "Medias S/.15") {
            precioUnitario = 15.0
        } else if (producto == "Casacas S/.180") {
            precioUnitario = 180.0
        }

        // calcula el subtotal
        val subtotal = cantidad * precioUnitario

        var descuento = 0.0
        // evalua si el radiobutton de desc10% esta selecionado
        if (rbDescuento10.isChecked) {
            descuento = 0.10   // establece el descuento de 10%
        } else {
            descuento = 0.20
        }

        // calcula el monto del descuento
        val montoDescuento = subtotal * descuento
        val total = subtotal - montoDescuento

        // muestra los detalles en una cadena multilinea
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

        // mensaje de Toast venta registrada
        Toast.makeText(applicationContext, "¡Venta Registrada!", Toast.LENGTH_SHORT).show()
    }

// reinicia los elementos de la interfaz
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

    //    este metodo se va encargar de crear el menu de opciones en esta actividad tienda
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //    estas funciones nos permiten navegar de la pantalla actual hacia los diferentes pantallas de la aplicacion
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

    //    este metodo evalua que accion va tomar cuando se selecciona un item del menu opciones y esto lo hace mediante el ID del elemento seleccionado
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
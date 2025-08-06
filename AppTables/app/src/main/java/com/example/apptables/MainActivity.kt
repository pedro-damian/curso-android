package com.example.apptables

import android.content.ContentValues
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    var tbproductos: TableLayout?=null
    lateinit var et1: EditText
    lateinit var et2: EditText
    lateinit var et3: EditText
    lateinit var btneliminar: Button
    var selectedRow: TableRow? = null   // variable para rastrear la fila seleccionada

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1=findViewById(R.id.et1)
        et2=findViewById(R.id.et2)
        et3=findViewById(R.id.et3)
        val btncerrar=findViewById<Button>(R.id.btncerrar)
        btneliminar = findViewById(R.id.btneliminar)
        val botonagregar=findViewById<Button>(R.id.btnagregar)

        tbproductos=findViewById(R.id.tbproductos)
        //tbproductos?.removeAllViews()


        botonagregar.setOnClickListener {

            var codigo=et1.text.toString()
            var descripcion=et2.text.toString()
            var precio=et3.text.toString()

            if(codigo.isEmpty()==false && descripcion.isEmpty()==false && precio.isEmpty()==false){
                llenarTabla()  // funcion llenar tabla
                et1.setText("")
                et2.setText("")
                et3.setText("")
                selectedRow = null
                btneliminar.isEnabled = false
                resetColorRegistros() // Resetear colores después de agregar
                Toast.makeText(this, "Se cargaron los datos del artículo", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Los campos deben tener texto", Toast.LENGTH_LONG).show()
            }
        }

        btncerrar.setOnClickListener{
            cerrar()
        }

        btneliminar.setOnClickListener {
            eliminarRegistro()
        }


    }
    fun llenarTabla(){
        //tbproductos?.removeAllViews()

        val registro= LayoutInflater.from(this).inflate(R.layout.item_table_layout_pn,null,false)
        val tvCodigo=registro.findViewById<View>(R.id.tvCodigo) as TextView
        val tvDescripcion=registro.findViewById<View>(R.id.tvDescripcion) as TextView
        val tvPrecio=registro.findViewById<View>(R.id.tvPrecio) as TextView
        tvCodigo.setText(et1.text.toString())
        tvDescripcion.setText(et2.text.toString())
        tvPrecio.setText(et3.text.toString())
        registro.setBackgroundColor(Color.WHITE)
        registro.setOnClickListener { clickRegistroProducto(it) }
        tbproductos?.addView(registro)

    }

//    fun eliminarRegistro() {
//        selectedRow?.let { row ->
//            val builder = AlertDialog.Builder(this)
//            builder
//                .setMessage("¿Estás seguro de que deseas eliminar este registro?")
//                .setTitle("Confirmar eliminación")
//                .setPositiveButton(android.R.string.yes) { _, _ ->
//                    tbproductos?.removeView(row)
//                    selectedRow = null
//                    et1.setText("")
//                    et2.setText("")
//                    et3.setText("")
//                    Toast.makeText(this, "Registro eliminado", Toast.LENGTH_SHORT).show()
//                }
//                .setNegativeButton(android.R.string.no) { _, _ ->
//                    Toast.makeText(this, "Eliminación cancelada", Toast.LENGTH_SHORT).show()
//                }
//            val dialog = builder.create()
//            dialog.show()
//        } ?: run {
//            Toast.makeText(this, "Por favor, selecciona un registro para eliminar", Toast.LENGTH_SHORT).show()
//        }
//    }

    fun eliminarRegistro() {
        if (selectedRow != null) {
            tbproductos?.removeView(selectedRow)
            selectedRow = null
            et1.setText("")
            et2.setText("")
            et3.setText("")
            btneliminar.isEnabled = false // Deshabilitar después de eliminar
            Toast.makeText(this, "Registro eliminado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Por favor, selecciona un registro para eliminar", Toast.LENGTH_SHORT).show()
        }
    }


    fun clickRegistroProducto(view: View){
        selectedRow = view as TableRow
        resetColorRegistros() // Resetear colores después de agregar
        selectedRow?.setBackgroundColor(Color.rgb(182, 193, 252))
        //val registro=view as TableRow

        btneliminar.isEnabled = true  //habilita el boton
        val controlCodigo=selectedRow?.getChildAt(0) as TextView
        val controlnombre=selectedRow?.getChildAt(1) as TextView
        val controlprecio=selectedRow?.getChildAt(2) as TextView
        val codigo=controlCodigo.text.toString()
        val nombre=controlnombre.text.toString()
        val precio=controlprecio.text.toString()

        if(!codigo.isEmpty()){

            et1.setText(codigo)
            et2.setText(nombre)
            et3.setText(precio)
        }else{
            et1.setText("")
            et2.setText("")
            et3.setText("")
            btneliminar.isEnabled = false  //deshabilita el boton
            Toast.makeText(this, "No se ha encontrado ningun registro", Toast.LENGTH_SHORT).show()
        }

    }

    fun resetColorRegistros(){
        for (i in 1 until tbproductos!!.childCount){
            val registros=tbproductos?.getChildAt(i)
            registros?.setBackgroundColor(Color.WHITE)

        }

    }

    fun cerrar(){

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage("Fin de la APP!!!")
            .setTitle("Cerrar APP")
            .setPositiveButton(android.R.string.yes){ dialog, which -> Toast.makeText(applicationContext, android.R.string.yes,
                Toast.LENGTH_SHORT).show()
                System.exit(0)
            }
            .setNegativeButton(android.R.string.no){ dialog, which -> Toast.makeText(applicationContext, android.R.string.no,
                Toast.LENGTH_SHORT).show()}

        val dialog: AlertDialog = builder.create()
        dialog.show()

    }
}
package com.example.appsqlite

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et1=findViewById(R.id.et1)
        et2=findViewById(R.id.et2)
        et3=findViewById(R.id.et3)
        val boton1=findViewById<Button>(R.id.boton1)
        val boton2=findViewById<Button>(R.id.boton2)
        val boton3=findViewById<Button>(R.id.boton3)
        val boton4=findViewById<Button>(R.id.boton4)
        val boton5=findViewById<Button>(R.id.boton5)
        val btncerrar=findViewById<Button>(R.id.btncerrar)

        tbproductos=findViewById(R.id.tbproductos)
        tbproductos?.removeAllViews()

        llenarTabla()

        boton1.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this,"administracion", null, 1)
            val bd = admin.writableDatabase

            var codigo=et1?.text.toString()
            var descripcion=et2?.text.toString()
            var precio=et3?.text.toString()

            if(codigo.isEmpty()==false && descripcion.isEmpty()==false && precio.isEmpty()==false){
                val registro = ContentValues()
                registro.put("codigo", et1.getText().toString())
                registro.put("descripcion", et2.getText().toString())
                registro.put("precio", et3.getText().toString())
                bd.insert("articulos", null, registro)
                bd.close()
                et1.setText("")
                et2.setText("")
                et3.setText("")
                Toast.makeText(this, "Se cargaron los datos del artículo", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Los campos deben tener texto", Toast.LENGTH_LONG).show()
            }

            llenarTabla()

        }

        boton2.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            var codigo=et1?.text.toString()

            if(codigo.isEmpty()==false) {
                val fila =
                    bd.rawQuery("select descripcion,precio from articulos where codigo=${et1.text.toString()}", null)
                if (fila.moveToFirst()) {
                    et2.setText(fila.getString(0))
                    et3.setText(fila.getString(1))
                } else
                    Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this,"Debe especificar un código!!!", Toast.LENGTH_LONG).show()
            }
            bd.close()

        }

        boton3.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val fila = bd.rawQuery("select codigo,precio from articulos where descripcion='${et2.text.toString()}'", null)
            if (fila.moveToFirst()) {
                et1.setText(fila.getString(0))
                et3.setText(fila.getString(1))
            } else
                Toast.makeText(this, "No existe un artículo con dicha descripción", Toast.LENGTH_SHORT).show()
            bd.close()

        }

        boton4.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val cant = bd.delete("articulos", "codigo=${et1.text.toString()}", null)
            bd.close()
            et1.setText("")
            et2.setText("")
            et3.setText("")
            if (cant == 1)
                Toast.makeText(this, "Se borró el artículo con dicho código", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "No existe un artículo con dicho código", Toast.LENGTH_SHORT).show()
            // cargalista()
            llenarTabla()
        }

        boton5.setOnClickListener {
            val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
            val bd = admin.writableDatabase
            val registro = ContentValues()
            registro.put("descripcion", et2.text.toString())
            registro.put("precio", et3.text.toString())
            val cant = bd.update("articulos", registro, "codigo=${et1.text.toString()}", null)
            bd.close()
            if (cant == 1)
                Toast.makeText(this, "se modificaron los datos", Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this, "no existe un artículo con el código ingresado", Toast.LENGTH_SHORT).show()
            //cargalista()
            llenarTabla()
        }

        btncerrar.setOnClickListener{
            cerrar()
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

    fun llenarTabla(){
        tbproductos?.removeAllViews()
        val con=AdminSQLiteOpenHelper(this,"administracion",null,1)
        val baseDatos=con.writableDatabase
        val fila=baseDatos.rawQuery("select codigo,descripcion,precio from articulos",null)
        fila.moveToFirst()
        do{
            val registro= LayoutInflater.from(this).inflate(R.layout.item_table_layout_pn,null,false)
            val tvCodigo=registro.findViewById<View>(R.id.tvCodigo) as TextView
            val tvDescripcion=registro.findViewById<View>(R.id.tvDescripcion) as TextView
            val tvPrecio=registro.findViewById<View>(R.id.tvPrecio) as TextView
            tvCodigo.setText(fila.getString(0))
            tvDescripcion.setText(fila.getString(1))
            tvPrecio.setText(fila.getString(2))

            tbproductos?.addView(registro)
        }while (fila.moveToNext())
    }

    fun clickRegistroProducto(view: View){
        resetColorRegistros()
        view.setBackgroundColor(Color.GRAY)
        val registro=view as TableRow
        val controlCodigo=registro.getChildAt(0) as TextView
        val codigo=controlCodigo.text.toString()
        val con=AdminSQLiteOpenHelper(this,"administracion",null,1)
        val baseDatos=con.writableDatabase
        if(!codigo.isEmpty()){
            val fila=baseDatos.rawQuery("select codigo,descripcion,precio from articulos where codigo='$codigo'", null)
            if(fila.moveToFirst()){
                et1?.setText(fila.getString(0))
                et2?.setText(fila.getString(1))
                et3?.setText(fila.getString(2))
            }else{
                et1?.setText("")
                et2?.setText("")
                et3?.setText("")
                Toast.makeText(this, "No se ha encontrado ningun registro", Toast.LENGTH_SHORT).show()
            }

        }

    }
    fun resetColorRegistros(){
        for (i in 0 .. tbproductos!!.childCount){
            val registros=tbproductos?.getChildAt(i)
            registros?.setBackgroundColor(Color.WHITE)
        }
    }
}
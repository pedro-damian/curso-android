package com.example.list_view

import android.os.Bundle
import android.widget.*
import android.widget.AdapterView
import android.widget.AdapterView.OnItemLongClickListener
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var milista: ListView
    lateinit var milista2: ListView
    val nombres: ArrayList<String> = ArrayList()
    lateinit var n: EditText
    lateinit var btnagregar: Button
    lateinit var btncerrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datos2 = arrayOf<String>("ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO")

        n = findViewById(R.id.txtnombre)
        btnagregar = findViewById(R.id.btnagregar)
        btncerrar = findViewById(R.id.btncerrar)
        milista2 = findViewById<ListView>(R.id.milista21)

        nombres.add("Perú")
        val arrayAdapter2 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres)
        milista2.adapter = arrayAdapter2


        milista = findViewById<ListView>(R.id.milista2)
        val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos2)
        milista.adapter = arrayAdapter

        milista.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val selectedItem = adapterView.getItemAtPosition(position) as String
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

            Toast.makeText(applicationContext,"click item $selectedItem esta es la posición $itemIdAtPos",Toast.LENGTH_SHORT).show()
        }

        milista2.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val selectedItem1 = adapterView.getItemAtPosition(position) as String
            val itemIdAtPos1 = adapterView.getItemIdAtPosition(position)

            val dialogo1 =
                AlertDialog.Builder(this@MainActivity)
            dialogo1.setTitle("Importante")
            dialogo1.setMessage("¿ Elimina este Nombre ?")
            dialogo1.setCancelable(false)
            dialogo1.setPositiveButton("Confirmar") { dialogo1, id ->
                nombres.remove(selectedItem1)
                arrayAdapter2.notifyDataSetChanged()
            }
            dialogo1.setNegativeButton(
                "Cancelar"
            ) { dialogo1, id -> }
            dialogo1.show()

        }

        btnagregar.setOnClickListener{
            nombres.add(n.getText().toString());
            arrayAdapter2.notifyDataSetChanged();
            n.setText("");
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
}
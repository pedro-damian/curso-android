package com.example.applicationnotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.lang.NumberFormatException
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var n1:EditText
    lateinit var n2:EditText
    lateinit var n3:EditText
    lateinit var r:TextView
    lateinit var r1: TextView
    lateinit var btnnuevo: Button
    lateinit var btncalcular: Button
    lateinit var btncerrar: Button
    lateinit var e1:RadioButton
    lateinit var e2:RadioButton
    lateinit var e3:RadioButton
    lateinit var e4:RadioButton
    lateinit var c1:CheckBox

    var pr: Float=0f
    var mpr: String= ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        n1 = findViewById(R.id.txt_nota1)
        n2 = findViewById(R.id.txt_nota2)
        n3 = findViewById(R.id.txt_nota3)
        r = findViewById(R.id.lbl_promedio)
        r1= findViewById(R.id.lbl_observacion)
        btnnuevo = findViewById(R.id.btn_nuevo)
        btncalcular = findViewById(R.id.btn_calcular)
        btncerrar = findViewById(R.id.btn_salir)
        e1 = findViewById(R.id.rbtn1)
        e2 = findViewById(R.id.rbtn2)
        e3 = findViewById(R.id.rbtn3)
        e4 = findViewById(R.id.rbtn4)

        btnnuevo.setOnClickListener{
            nuevo()
        }
        btncerrar.setOnClickListener {
            cerrar()
        }
        btncalcular.setOnClickListener {
            try {
                if(validar()){
                    var tn1 = n1.text.toString().toFloat()
                    var tn2 = n2.text.toString().toFloat()
                    var tn3 = n3.text.toString().toFloat()
                    pr = (tn1+tn2+tn3)/3
                    r.text = pr.toString()
                    if (pr>=10.5){
                        mpr="Aprobado, le falta " + (20.2 - pr) + " para 20"
                    }
                    else {
                        mpr = "Desaprobado le falta " + (11 - pr) + " para tener 11"
                    }
                    r1.text = mpr.toString()
                }

            }
            catch (e:NumberFormatException){
               Toast.makeText(applicationContext, "ingrese numeros validos", Toast.LENGTH_SHORT).show()
                   nuevo()

            }
        }

    }

    fun validar():Boolean {
        var respuesta = true
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage("Ingrese un Numero:")
            .setTitle("Error de datos")
        val dialog: AlertDialog = builder.create()
        if (n1.text.toString().trim().isEmpty()){
            respuesta = false
            dialog.show()
            n1.requestFocus()
        }
        if (n2.text.toString().trim().isEmpty()){
            respuesta = false
            dialog.show()
            n2.requestFocus()
        }
        if (n3.text.toString().trim().isEmpty()){
            respuesta = false
            dialog.show()
            n3.requestFocus()
        }
        return respuesta
    }

    fun nuevo(){
        n1.setText("")
        n2.setText("")
        n3.setText("")
        r.setText("")
        r1.setText("")
        n1.requestFocus()
    }

    fun cerrar(){
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage("Fin de la aplicacion")
            .setTitle("Cerrar aplicacion")
            .setPositiveButton(android.R.string.yes){dialog, which -> Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()
                System.exit(0)        }
            .setNegativeButton(android.R.string.no){dialog, which -> Toast.makeText(applicationContext, android.R.string.no, Toast.LENGTH_SHORT).show()}
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}


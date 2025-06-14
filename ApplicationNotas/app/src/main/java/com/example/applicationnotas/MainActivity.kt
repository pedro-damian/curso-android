package com.example.applicationnotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    // inicializar variables publicas
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
    lateinit var c1:CheckBox
    lateinit var cboxlista: Spinner

    var pr: Float=0f
    var mpr: String= ""
    var datos = arrayOf("C#", "Java", "Python", "Kotlin", "PHP")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // vincula los elementos de la UI con el layout
        n1 = findViewById(R.id.txt_nota1)
        n2 = findViewById(R.id.txt_nota2)
        n3 = findViewById(R.id.txt_nota3)
        r = findViewById(R.id.lbl_promedio)
        r1= findViewById(R.id.lbl_observacion)
        btnnuevo = findViewById(R.id.btn_nuevo)
        btncalcular = findViewById(R.id.btn_calcular)
        btncerrar = findViewById(R.id.btn_salir)
        e1 = findViewById(R.id.rbtn_sumar)
        e2 = findViewById(R.id.rbtn_restar)
        e3 = findViewById(R.id.rbtn_multiplicar)
        cboxlista = findViewById(R.id.cbox_lista)

        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,datos)
        cboxlista.setAdapter(adapter)

        c1 = findViewById(R.id.chbx_mensaje)

        btnnuevo.setOnClickListener{
            nuevo()
        }
        btncerrar.setOnClickListener {
            cerrar()
        }
        btncalcular.setOnClickListener {
            try {
                if(validar()){
                    // convierte el texto a float
                    var tn1 = n1.text.toString().toFloat()
                    var tn2 = n2.text.toString().toFloat()
                    var tn3 = n3.text.toString().toFloat()

                    if(e1.isChecked){
                        pr = tn1 + tn2 + tn3
                        mpr = "Se han sumado los numeros"
                    }
                    if(e2.isChecked){
                        pr = tn1 - tn2 - tn3
                        mpr = "Se han restado los numeros"
                    }
                    if(e3.isChecked){
                        pr = tn1 * tn2 * tn3
                        mpr = "Se han multiplicado los numeros"
                    }
                    if (e1.isChecked==false && e2.isChecked==false && e3.isChecked==false) {
                        // calcula el promedio
                        pr = (tn1+tn2+tn3)/3
                        // condicional que evalua si el promedio es mayor a 10.5 muestra aprobado y cuanto faltaria para 20
                        if (pr>=10.5){
                            mpr="Aprobado, le falta ${String.format("%.1f",20 - pr)}  para 20"
                        }
                        // de lo contrario muestra desaprobado y cuanto faltaria para 11
                        else {
                            mpr = "Desaprobado le falta ${String.format("%.1f",11 - pr)} para tener 11"
                        }

                    }

                    if (c1.isChecked) {
                        mpr = "Aplicativo funcionando con exito"
                    }

                    var opcion: String = cboxlista.selectedItem.toString()
                    if(opcion.equals("C#")){
                        mpr = "Seleccionaste lenguaje C#"
                    }
                    if(opcion.equals("Java")){
                        mpr = "Seleccionaste lenguaje Java"
                    }
                    if(opcion.equals("Python")){
                        mpr = "Seleccionaste lenguaje Python"
                    }
                    if(opcion.equals("Kotlin")){
                        mpr = "Seleccionaste lenguaje Kotlin"
                    }
                    if(opcion.equals("PHP")){
                        mpr = "Seleccionaste lenguaje PHP"
                    }

                    // Muestra el resultado en el label promedio
                    r.text = String.format("%.1f", pr)

                    // muestra el resultado en el label observacion
                    r1.text = mpr.toString()
                }

            }
            catch (e:NumberFormatException){
                // Manejo de error: muestra un mensaje de dialogo con la libreria toast "ingrese numero"
               Toast.makeText(applicationContext, "ingrese numeros validos", Toast.LENGTH_SHORT).show()
                // funcion limpia los campos
                   nuevo()

            }
        }

    }


    // verifica que los campos de notas no esten vacios
    fun validar():Boolean {
        var respuesta = true
        // crea un dialogo de alerta "ingrese numero" y un titulo "Error de datos"
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage("Ingrese un Numero:")
            .setTitle("Error de datos")
        val dialog: AlertDialog = builder.create()

        // condicion que evalua si los campos estan vacios establece la variable respuesta en false entonces muestra el dialogo y pone el foco en el campo vacio
        if (n1.text.toString().trim().isEmpty()){
            respuesta = false
            dialog.show()
            n1.requestFocus()
        }
        if (n2.text.toString().trim().isEmpty()){
            respuesta = false
            dialog.show()
            //n2.requestFocus()
        }
        if (n3.text.toString().trim().isEmpty()){
            respuesta = false
            dialog.show()
            //n3.requestFocus()
        }
        // retorna una respuesta true si todos los campos estan llenos
        return respuesta
    }

    // limpia todos los campos de entrada y salida
    fun nuevo(){
        n1.setText("")
        n2.setText("")
        n3.setText("")
        r.setText("")
        r1.setText("")
        e1.setChecked(false)
        e2.setChecked(false)
        e3.setChecked(false)

        // establece el foco en el primer campo n1
        n1.requestFocus()
    }

    // muestra un dialogo para confirmar si el usuario desea cerrar la aplicacion
    fun cerrar(){
        // crea un dialogo de alerta "Fin de la aplicacion" y un titulo "Cerrar aplicacion"
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder
            .setMessage("Fin de la aplicacion")
            .setTitle("Cerrar aplicacion")
                // crea el boton SI confirma salir de la aplicacion
            .setPositiveButton(android.R.string.yes){dialog, which -> Toast.makeText(applicationContext, android.R.string.yes, Toast.LENGTH_SHORT).show()
                System.exit(0) }
                // crea el boton NO se queda en la aplicacion
            .setNegativeButton(android.R.string.no){dialog, which -> Toast.makeText(applicationContext, "Cancelado", Toast.LENGTH_SHORT).show()}
        // crea el mensaje del dialogo
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}


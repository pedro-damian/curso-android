package com.example.jetpackcomposepruebas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposepruebas.ui.theme.JetPackComposePruebasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            //PrimerComposable()
            SegundoComposable()
        }
    }
}

@Composable
fun PrimerComposable() {

    Column {

        Spacer(modifier = Modifier.padding(top = 35.dp))

        Row {
            Text(text = "Texto1")
            Spacer(modifier = Modifier.width(75.dp))
            Text(text = "Texto2")
        }

        Column(modifier = Modifier.fillMaxSize().padding(top = 75.dp)) {
            Text(text="Hola columna")
            Text(text="Hola Kotlin")

            Spacer(modifier = Modifier.height(35.dp)) // espacio responsivo, solo va dentro de componentes layout (colunm, row, box)

            Row() {
                Text(text="Hola Fila")
                Spacer(modifier = Modifier.width(35.dp))
                Text(text="Hola Fila2")
            }
        }

    }

}

@Composable
fun SegundoComposable() {

    Box(modifier = Modifier.fillMaxSize().padding(top = 35.dp, start = 16.dp, end = 16.dp)){

        /* Text(text = "Arriba Izquierda", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "Centrado", modifier = Modifier.align(Alignment.Center))
        Text(text = "Abajo Derecha", modifier = Modifier.align(Alignment.BottomEnd)) */


    }

}


@Preview
@Composable
fun PrimerComposableVista() {
    //PrimerComposable()
    SegundoComposable()
}
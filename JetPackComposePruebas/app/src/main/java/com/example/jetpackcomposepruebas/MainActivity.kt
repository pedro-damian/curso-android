package com.example.jetpackcomposepruebas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    var colorFondo by remember { mutableStateOf(Color.White)}

    var posicionTexto by remember { mutableStateOf(Offset(0f, 0f)) }

    var anchoPantalla by remember { mutableStateOf(0f) }
    var altoPantalla by remember { mutableStateOf(0f) }
    var anchoTexto by remember { mutableStateOf(0f) }
    var altoTexto by remember { mutableStateOf(0f) }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 35.dp, start = 16.dp, end = 16.dp)
        .background(colorFondo)
        .onGloballyPositioned {coordinates ->
            anchoPantalla=coordinates.size.width.toFloat()
            altoPantalla=coordinates.size.height.toFloat()

        }){

        /* Text(text = "Arriba Izquierda", modifier = Modifier.align(Alignment.TopStart))
        Text(text = "Centrado", modifier = Modifier.align(Alignment.Center))
        Text(text = "Abajo Derecha", modifier = Modifier.align(Alignment.BottomEnd)) */

        Image(
            painter = painterResource(id = R.drawable.utensilios),
            contentDescription = "Utensilios de Barberia",
            modifier = Modifier.align(Alignment.Center).fillMaxSize()
        )

        Text(
            text = "Utensilios de barberia",
            fontSize = 24.sp,
            color = Color.Red,
            textAlign = TextAlign.Center,
            //modifier = Modifier.align(Alignment.Center)
            modifier = Modifier
                .onGloballyPositioned{coordinates ->
                    anchoTexto=coordinates.size.width.toFloat()
                    altoTexto=coordinates.size.height.toFloat()

                    // centrar texto en pantalla
                    if (posicionTexto==Offset(0f,0f)){
                        posicionTexto= Offset((anchoPantalla-anchoTexto)/2, (altoPantalla-altoTexto)/2)
                    }

                }
                .offset{ IntOffset(posicionTexto.x.toInt(), posicionTexto.y.toInt())}
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()
                        posicionTexto += Offset(dragAmount.x, dragAmount.y)
                    }
                }
            )

        Button(
            onClick = {colorFondo = Color(colorAleatorio())},
            modifier = Modifier.align(Alignment.TopStart)
            )
        {
            Text(text = "Fondo")
        }

    }

}

//fun colorAleatorio():Color{
//    val rojo = (0..255).random()
//    val verde = (0..255).random()
//    val azul = (0..255).random()
//
//    return Color(red=rojo, green=verde, blue=azul)
//}

fun colorAleatorio():Long{
    return (0xFFFFFF.. 0xFFFFFFFFF).random()
}


@Preview
@Composable
fun PrimerComposableVista() {
    //PrimerComposable()
    SegundoComposable()
}
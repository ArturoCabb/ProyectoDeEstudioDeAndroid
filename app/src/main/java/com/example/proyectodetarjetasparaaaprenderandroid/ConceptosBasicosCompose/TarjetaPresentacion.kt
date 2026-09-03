package com.example.proyectodetarjetasparaaaprenderandroid.ConceptosBasicosCompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectodetarjetasparaaaprenderandroid.R
import com.example.proyectodetarjetasparaaaprenderandroid.ui.theme.ProyectoDeTarjetasParaaAprenderAndroidTheme
import java.util.HashMap

class TarjetaPresentacion {
}

@Composable
fun DatosPersonales() {
    val image = painterResource(R.drawable.ic_task_completed)
    Column(modifier = Modifier.padding(8.dp)) { }
    Image(image, contentDescription = null)
    Text("Arturo Caballero Ortega", fontSize = 26.sp, fontWeight = FontWeight.Bold)
    Text("Ing en tecnologias computacionales", color = Color(0xFF3ddc84))
}

@Composable
fun DatosContacto(icon: Painter, texto: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            icon,
            contentDescription = null, Modifier.height(50.dp))
        Text(texto)
    }
}

@Composable
fun Contacto() {
    val listaDatos = HashMap<String, Painter>()
    listaDatos["+527225470398"] = painterResource(R.drawable.ic_launcher_foreground)
    listaDatos["arturcabbb@gmail.com"] = painterResource(R.drawable.ic_launcher_foreground)
    listaDatos["@arturocabb"] = painterResource(R.drawable.ic_launcher_foreground)
    Column() {
        listaDatos.forEach { (text, painter) ->
            DatosContacto(painter, text)
        }
    }
}

@Composable
fun TarjetaDePresentacion() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        DatosPersonales()
        Spacer(Modifier.height(50.dp))
        Contacto()
    }
}

@Preview
@Composable
fun TarjetaPresentacionPreview() {
    ProyectoDeTarjetasParaaAprenderAndroidTheme {
        TarjetaDePresentacion()
    }
}
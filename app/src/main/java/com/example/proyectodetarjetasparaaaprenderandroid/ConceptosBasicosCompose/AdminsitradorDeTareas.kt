package com.example.proyectodetarjetasparaaaprenderandroid.ConceptosBasicosCompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectodetarjetasparaaaprenderandroid.R
import com.example.proyectodetarjetasparaaaprenderandroid.ui.theme.ProyectoDeTarjetasParaaAprenderAndroidTheme

class AdminsitradorDeTareas {
}

@Composable
fun Adminstrador(modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().fillMaxHeight()
    ) {
        val image = painterResource(R.drawable.ic_task_completed)
        Image(
            image,
            contentDescription = null
        )
        Text(
            "All tasks completed",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 24.dp, end = 8.dp)
        )
        Text(
            "Nice work!",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 24.dp, end = 8.dp)
        )
    }
}

@Preview
@Composable
fun AdministradorPreview() {
    ProyectoDeTarjetasParaaAprenderAndroidTheme {
        Adminstrador()
    }
}

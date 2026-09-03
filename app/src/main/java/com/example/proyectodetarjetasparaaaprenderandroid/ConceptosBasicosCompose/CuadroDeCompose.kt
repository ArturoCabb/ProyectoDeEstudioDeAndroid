package com.example.proyectodetarjetasparaaaprenderandroid.ConceptosBasicosCompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectodetarjetasparaaaprenderandroid.ui.theme.ProyectoDeTarjetasParaaAprenderAndroidTheme

class CuadroDeCompose {
}

@Composable
fun ComposableInforCard(
    title: String,
    description: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
            .background(color)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            title,
            modifier = Modifier.padding(end = 16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            description,
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun CuadroCompose(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(Modifier.weight(1f)) {
            ComposableInforCard(
                "Text composable",
                "Displays text and follows the recommended Material Design guidelines.",
                Color(0xFFEADDFF),
                modifier.weight(1f)
            )
            ComposableInforCard(
                "Image composable",
                "Creates a composable that lays out and draws a given Painter class object.",
                Color(0xFFD0BCFF),
                modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInforCard(
                "Row composable",
                "A layout composable that places its children in a horizontal sequence.",
                Color(0xFFB69DF8),
                modifier.weight(1f)
            )
            ComposableInforCard(
                "Column composable",
                "A layout composable that places its children in a vertical sequence.",
                Color(0xFFF6EDFF),
                modifier.weight(1f)
            )
        }
    }
}

@Preview
@Composable
fun CuadroComposePreview() {
    ProyectoDeTarjetasParaaAprenderAndroidTheme {
        CuadroCompose()
    }
}
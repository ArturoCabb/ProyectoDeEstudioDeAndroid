package com.example.proyectodetarjetasparaaaprenderandroid.CrearAppDiceRoller

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectodetarjetasparaaaprenderandroid.R
import com.example.proyectodetarjetasparaaaprenderandroid.ui.theme.ProyectoDeTarjetasParaaAprenderAndroidTheme

class Limonada {
}

@Composable
fun LemonadeImage(
    modifier: Modifier = Modifier.fillMaxSize()
        .wrapContentSize(Alignment.Center)
) {
    var stateA by remember { mutableIntStateOf(1) }
    var clicCount by remember { mutableIntStateOf(0) }
    val imageDados = when (stateA) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val contentText = when (stateA) {
        1 -> R.string.tap_lemon
        2 -> R.string.keep_tap
        3 -> R.string.tap_to_drink
        4 -> R.string.tap_empty_glass
        else -> R.string.tap_lemon
    }
    val contentDescription = when (stateA) {
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        3 -> R.string.glass_of_lemonade
        4 -> R.string.empty_glass
        else -> R.string.lemon_tree
    }
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painterResource(imageDados),
            contentDescription = stringResource(contentDescription),
            Modifier
                .wrapContentSize()
                .border(2.dp, Color(105f, 205f, 216f),
                    shape = CutCornerShape(4.dp)
                )
                .clickable {
                    when (stateA) {
                        1 -> {
                            clicCount = (1..6).random()
                            stateA++
                        }
                        2 -> {
                            if (clicCount != 0) clicCount--
                            else stateA++
                        }
                        3 -> stateA ++
                        4 -> stateA = 1
                        else -> stateA = 1
                    }
                }
        )
        Spacer(Modifier.height(16.dp))
        Text(stringResource(contentText), fontSize = 18.sp)
    }
}

@Preview(showBackground = true, name = "Cualquier nombre")
@Composable
fun LemonadeApp() {
    ProyectoDeTarjetasParaaAprenderAndroidTheme {
        LemonadeImage()
    }
}
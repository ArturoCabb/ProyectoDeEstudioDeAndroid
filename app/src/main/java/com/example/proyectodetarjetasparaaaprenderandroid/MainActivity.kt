package com.example.proyectodetarjetasparaaaprenderandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.proyectodetarjetasparaaaprenderandroid.ui.DessertReleaseApp
import com.example.proyectodetarjetasparaaaprenderandroid.ui.theme.DessertReleaseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DessertReleaseTheme {
                DessertReleaseApp()
            }
        }
    }
}
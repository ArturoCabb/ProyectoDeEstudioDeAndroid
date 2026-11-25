package com.example.proyectodetarjetasparaaaprenderandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.proyectodetarjetasparaaaprenderandroid.ui.JuiceTrackerApp
import com.example.proyectodetarjetasparaaaprenderandroid.ui.theme.JuiceTrackerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            JuiceTrackerTheme {
                JuiceTrackerApp()
            }
        }
    }
}
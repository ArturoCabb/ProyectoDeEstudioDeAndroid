package com.example.proyectodetarjetasparaaaprenderandroid

import android.app.Application
import com.example.proyectodetarjetasparaaaprenderandroid.data.AppContainer
import com.example.proyectodetarjetasparaaaprenderandroid.data.DefaultAppContainer

class MarsPhotosApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
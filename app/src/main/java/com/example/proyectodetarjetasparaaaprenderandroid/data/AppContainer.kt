package com.example.proyectodetarjetasparaaaprenderandroid.data

import android.content.Context

interface AppContainer {
    val bluromaticRepository: BluromaticRepository
}

class DefaultAppContainer(context: Context) : AppContainer {
    override val bluromaticRepository = WorkManagerBluromaticRepository(context)
}
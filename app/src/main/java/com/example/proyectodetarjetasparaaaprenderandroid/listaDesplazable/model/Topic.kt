package com.example.proyectodetarjetasparaaaprenderandroid.listaDesplazable.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringResourceId: Int,
    val coursesCount: Int,
    @DrawableRes val imageResourceId: Int
)
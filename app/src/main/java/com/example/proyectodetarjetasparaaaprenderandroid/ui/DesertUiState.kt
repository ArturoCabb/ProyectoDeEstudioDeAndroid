package com.example.proyectodetarjetasparaaaprenderandroid.ui

import androidx.annotation.DrawableRes
import com.example.proyectodetarjetasparaaaprenderandroid.data.Datasource.dessertList

data class DesertUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertPrice: Int = dessertList[currentDessertIndex].price,
    @DrawableRes val currentDessertImageId: Int = dessertList[currentDessertIndex].imageId
)

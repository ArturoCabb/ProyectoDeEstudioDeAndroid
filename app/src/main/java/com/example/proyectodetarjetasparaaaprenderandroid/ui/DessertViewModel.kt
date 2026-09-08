package com.example.proyectodetarjetasparaaaprenderandroid.ui

import androidx.lifecycle.ViewModel
import com.example.proyectodetarjetasparaaaprenderandroid.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(DesertUiState())
    val uiState: StateFlow<DesertUiState> = _uiState.asStateFlow()

    fun onDessertClicked() {
        _uiState.update { cupcakeUiState ->
            val dessertSold = cupcakeUiState.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertSold)
            cupcakeUiState.copy(
                currentDessertIndex = nextDessertIndex,
                revenue = cupcakeUiState.revenue + cupcakeUiState.currentDessertPrice,
                dessertsSold = dessertSold,
                currentDessertImageId = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }
    }

    private fun determineDessertIndex(dessertSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else break
        }
        return dessertIndex
    }
}
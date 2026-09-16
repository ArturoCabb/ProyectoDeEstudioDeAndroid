package com.example.proyectodetarjetasparaaaprenderandroid

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.proyectodetarjetasparaaaprenderandroid.ui.SelectOptionScreen
import org.junit.Rule
import org.junit.Test

class CupcakeOrderScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun selectOptionScreen_verifyContent() {
        // Given list of options
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")
        // And subtotal
        val subtotal = "$100"

        // When SelectOptionScreen is loaded
        composeTestRule.setContent {
            SelectOptionScreen(subtotal, flavors)
        }

        // Then all the options are displayed on the screen.
        flavors.forEach { flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        // And then subtotal is displayed correctly
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                R.string.subtotal_price, subtotal))
            .assertIsDisplayed()

        // And then next button is disabled
        composeTestRule.onNodeWithStringId(R.string.next).assertIsNotEnabled()
    }
    // TODO: Verifica el contenido de la pantalla de inicio
    // TODO: Verifica el contenido de la pantalla de resumen
    // TODO: Verifica que el botón Next esté habilitado cuando se seleccione una opción en la
    // pantalla de selección de sabores
}
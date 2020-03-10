package hr.hofman.composednews

import androidx.compose.Model

sealed class Screen {
    object Home : Screen()
    object Headlines : Screen()
    object Following : Screen()
}

@Model
object ComposedNewsStatus {
    var currentScreen: Screen = Screen.Home
}

/**
 * Temporary solution pending navigation support.
 */
fun navigateTo(destination: Screen) {
    ComposedNewsStatus.currentScreen = destination
}
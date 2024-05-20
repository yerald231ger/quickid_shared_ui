package ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ui.components.ScreenHeader

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScreenHeader(screenTitle = "Settings")
    }
}
package ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ui.components.ScreenHeader

@Composable
fun SettingsScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ScreenHeader(screenTitle = "Settings")
    }
}
package ui

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem (
    val route: String,
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean
)
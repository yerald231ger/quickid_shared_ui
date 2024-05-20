package ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ui.screens.HomeScreen
import ui.screens.IdentityFilesScreen
import ui.screens.SettingsScreen
import ui.theme.QuickIdThemes

@Composable
fun AppNavigation() {

    QuickIdThemes {
        Surface {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            Scaffold(
                bottomBar = {
                    BottomAppBar(
                        actions = {
                            IconButton(onClick = {

                            }) {
                                Icon(
                                    Icons.Default.Edit,
                                    contentDescription = "Home screen"
                                )
                            }
                            IconButton(onClick = {

                            }) {
                                Icon(
                                    Icons.Default.Delete,
                                    contentDescription = "All files",
                                )
                            }
                        },
                        floatingActionButton = {
                            FloatingActionButton(
                                onClick = {

                                },
                                containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                                elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                            ) {
                                Icon(Icons.Filled.Add, "Localized description")
                            }
                        }
                    )
                },
            ) { _ ->
                NavHost(
                    navController = navController,
                    startDestination = AppScreens.HomeScreen.route
                ) {
                    composable(AppScreens.HomeScreen.route) {
                        HomeScreen(navController)
                    }
                    composable(AppScreens.IdentityFilesScreen.route) {
                        IdentityFilesScreen(navController)
                    }
                    composable(AppScreens.SettingsScreen.route) {
                        SettingsScreen(navController)
                    }
                }
            }
        }
    }
}
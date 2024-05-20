import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import core.infrastructure.FileRepository
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.icons.Camera
import ui.icons.Description
import ui.icons.Inventory2
import ui.navigation.AppNavigation
import ui.screens.HomeScreen
import ui.theme.QuickIdThemes

@Composable
@Preview
fun App(repository: FileRepository) {
    QuickIdThemes {
        AppNavigation()
    }
}
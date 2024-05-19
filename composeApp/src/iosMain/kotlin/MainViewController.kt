import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import infrastructure.di.AppContainer
import infrastructure.di.QuickIdDatabaseFactory

fun MainViewController() = ComposeUIViewController {
    val repository = remember { AppContainer(QuickIdDatabaseFactory()).fileRepository }
    AppContainer(QuickIdDatabaseFactory())
    App(repository)
}
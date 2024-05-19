import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import core.infrastructure.FileRepository
import core.models.IdentityFile
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.theme.QuickIdThemes

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(repository: FileRepository) {
    QuickIdThemes {
        val files by repository.getFiles(null).collectAsState(emptyList())
        val scope = rememberCoroutineScope()
        Column {
            Row {
                Button(onClick = {
                    scope.launch {
                        val randomNumber = (0..100).random()
                        repository.saveFile(IdentityFile.create("file$randomNumber.txt", "content$randomNumber"))
                    }
                }) {
                    Text("Add file")
                }
            }
            files.forEach {
                Row { Text(it.name) }
            }
        }

    }
}
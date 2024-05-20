import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.infrastructure.FileRepository
import core.models.IdentityFile
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(private val repository: FileRepository) : ViewModel() {
    val indexUiState: StateFlow<IndexUiState> =
        combine(repository.getTopFiles(), repository.getRecentFiles()) { topFiles, recentFiles ->
            IndexUiState(topFiles, recentFiles)
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            IndexUiState()
        )

    val identityFileUiState: StateFlow<IdentityFileUiState> =
        repository.getFiles(null).map {
            IdentityFileUiState(it)
        }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            IdentityFileUiState()
        )

    fun saveFile(identityFile: IdentityFile) {
        viewModelScope.launch {
            repository.saveFile(identityFile)
        }
    }
}

data class IndexUiState(
    val topIdentityFiles: List<IdentityFile> = listOf(),
    val recentIdentityFiles: List<IdentityFile> = listOf()
)

data class IdentityFileUiState(
    val identityFiles: List<IdentityFile> = listOf()
)
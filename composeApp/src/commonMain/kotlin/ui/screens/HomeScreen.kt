package ui.screens

import MainViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import core.infrastructure.FileRepository
import core.models.IdentityFile
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch
import ui.components.FileItem
import ui.components.TitleContainer

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: MainViewModel
) {
    val indexUiState by viewModel.indexUiState.collectAsState()
    val identityFileUiState by viewModel.identityFileUiState.collectAsState()
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize()
    ) {
        Column {
            QuickIdentityFilesSection(indexUiState.topIdentityFiles)
            RecentIdentityFileSection(indexUiState.recentIdentityFiles)
        }
    }
}


@Composable
fun RecentIdentityFileSection(files: List<IdentityFile>, onClickEdit: () -> Unit = {}) {
    Row {
        TitleContainer(
            title = "Quick access files", label = "-"
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(files) { _, file ->
                    FileItem(identityFile = file)
                }
            }
        }
    }
}


@Composable
fun QuickIdentityFilesSection(files: List<IdentityFile>, onClickAdd: () -> Unit = {}) {
    Row {
        TitleContainer(
            title = "Recent files", label = "+",
            onClickLabel = onClickAdd
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                itemsIndexed(files) { _, file ->
                    FileItem(identityFile = file)
                }
            }
        }
    }
}

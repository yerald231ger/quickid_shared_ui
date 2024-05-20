package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import core.models.IdentityFile
import ui.components.FileItem
import ui.components.ScreenHeader
import ui.components.TitleContainer

@Composable
fun HomeScreen(
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .fillMaxSize()
    ) {
        Column {
            QuickIdentityFilesSection(emptyList())
            RecentIdentityFileSection(emptyList())
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

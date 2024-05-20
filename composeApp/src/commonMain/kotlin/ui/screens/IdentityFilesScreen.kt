package ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import core.models.IdentityFile
import ui.components.FileListItem
import ui.components.ScreenHeader

@Composable
fun IdentityFilesScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
    ) {
        Column {
            ScreenHeader(screenTitle = "Identity Files")
            ListIdentityFilesSection()
        }
    }
}

@Composable
fun ListIdentityFilesSection(files: List<IdentityFile> = emptyList()) {
    Row {
        LazyColumn {
            items(files) { file ->
                FileListItem(identityFile = file)
            }
        }
    }
}
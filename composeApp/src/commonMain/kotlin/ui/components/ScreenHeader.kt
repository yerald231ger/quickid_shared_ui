package ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun ScreenHeader(
    screenTitle: String = "Screen Title",
    onClickSearch: () -> Unit = {},
    onClickMore: () -> Unit = {}
) {
    Row {
        Box(
            modifier = Modifier
                .height(54.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.surface)
        ) {
            Text(
                text = screenTitle,
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 16.dp),
            )
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(end = 32.dp),
                onClick = {
                    onClickSearch()
                },
                content = {
                    Icon(
                        Icons.Default.Search,
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = "More Options"
                    )
                }
            )
            IconButton(
                modifier = Modifier
                    .align(Alignment.CenterEnd),
                onClick = {
                    onClickMore()
                },
                content = {
                    Icon(
                        Icons.Default.MoreVert,
                        tint = MaterialTheme.colorScheme.onSurface,
                        contentDescription = "More Options"
                    )
                }
            )
        }
    }
}
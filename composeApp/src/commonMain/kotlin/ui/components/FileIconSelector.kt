package ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import core.constants.IdentityFileType
import ui.icons.Description

@Composable
fun fileIconSelector(identityFileType: IdentityFileType): ImageVector {
    return when (identityFileType) {
        IdentityFileType.ID -> Icons.Default.Description
        IdentityFileType.CONTRACT -> Icons.Default.Description
        IdentityFileType.SOCIAL_SECURITY -> Icons.Default.Description
        IdentityFileType.PASSPORT -> Icons.Default.Description
        IdentityFileType.CAR_INSURANCE -> Icons.Default.Description
        IdentityFileType.DRIVER_LICENSE -> Icons.Default.Description
        IdentityFileType.OTHER -> Icons.Default.Description
    }
}
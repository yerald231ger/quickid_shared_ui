package infrastructure.mapping

import core.constants.IdentityFileType
import core.models.IdentityFile
import infrastructure.entities.EntityFile

fun IdentityFile.toEntityFile(): EntityFile {
    return EntityFile(
        id = this.id,
        name = this.name,
        description = this.description,
        importance = this.importance,
        identityFileType = this.identityFileType.ordinal,
        path = this.path
    )
}

fun EntityFile.toIdentityFile(): IdentityFile {
    IdentityFile.create(this.id, this.name).also { identityFile ->
        identityFile.description = this.description
        identityFile.importance = this.importance
        identityFile.identityFileType = IdentityFileType.fromInt(this.identityFileType)
        identityFile.path = this.path
        return identityFile
    }
}
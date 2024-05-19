package core.infrastructure

import core.models.IdentityFile
import kotlinx.coroutines.flow.Flow

interface FileRepository {
    fun getTopFiles(): Flow<List<IdentityFile>>
    fun getRecentFiles(): Flow<List<IdentityFile>>
    fun getFiles(id: String?): Flow<List<IdentityFile>>
    suspend fun saveFile(identityFile: IdentityFile)
    suspend fun deleteFile(identityFile: IdentityFile)
    suspend fun countFiles(): Int
    suspend fun updateFile(identityFile: IdentityFile)
}
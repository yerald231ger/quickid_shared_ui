package infrastructure.repositores

import core.infrastructure.FileRepository
import core.models.IdentityFile
import infrastructure.database.QuickIdDatabase
import infrastructure.mapping.toEntityFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class QuickIdFileRepository(
    private var database: QuickIdDatabase,
    private var scope: CoroutineScope
) : FileRepository {
//    override fun getTopFiles(): Flow<List<IdentityFile>> {
//        return database.fileDao().getAllAsFlow().map { list ->
//            list.map {
//                it.toIdentityFile()
//            }
//        }
//    }
//
//    override fun getRecentFiles(): Flow<List<IdentityFile>> {
//        return database.fileDao().getAllAsFlow().map { list ->
//            list.map {
//                it.toIdentityFile()
//            }
//        }
//    }
//
//    override fun getFiles(id: String?): Flow<List<IdentityFile>> {
//        return if (id == null) {
//            database.fileDao().getAllAsFlow().map { list ->
//                list.map {
//                    it.toIdentityFile()
//                }
//            }
//        } else
//            database.fileDao().getAllAsFlow().map { list ->
//                list.filter { it.id == id }.map {
//                    it.toIdentityFile()
//                }
//            }
//    }

    override suspend fun saveFile(identityFile: IdentityFile) {
        database.fileDao().insert(identityFile.toEntityFile())
    }

    override suspend fun deleteFile(identityFile: IdentityFile) {
        database.fileDao().delete(identityFile.toEntityFile())
    }

    override suspend fun countFiles(): Int {
        return database.fileDao().count()
    }

    override suspend fun updateFile(identityFile: IdentityFile) {
        TODO("Not yet implemented")
    }

}
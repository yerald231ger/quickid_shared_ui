package infrastructure.di

import core.infrastructure.FileRepository
import infrastructure.repositores.QuickIdFileRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class AppContainer(
    private val factory: QuickIdDatabaseFactory,
) {
    val fileRepository: FileRepository by lazy {
        QuickIdFileRepository (
            database = factory.createRoomDatabase(),
            scope = CoroutineScope(Dispatchers.Default + SupervisorJob()),
        )
    }
}

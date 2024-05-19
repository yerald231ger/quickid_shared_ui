package infrastructure.di

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import infrastructure.database.QuickIdDatabase
import infrastructure.database.dbFileName
import infrastructure.database.instantiateImpl
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSURL
import platform.Foundation.NSUserDomainMask

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
actual class QuickIdDatabaseFactory {

    actual fun createRoomDatabase(): QuickIdDatabase {
        val dbFile = "${fileDirectory()}/$dbFileName"

        return Room.databaseBuilder<QuickIdDatabase>(
            name = dbFile,
            factory =  { QuickIdDatabase::class.instantiateImpl() }
        ).setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }

    @OptIn(ExperimentalForeignApi::class)
    private fun fileDirectory(): String {
        val documentDirectory: NSURL? = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(documentDirectory).path!!
    }

}
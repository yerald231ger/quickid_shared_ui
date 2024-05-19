package infrastructure.database

import androidx.room.Database
import androidx.room.RoomDatabase
import infrastructure.entities.EntityFile
import infrastructure.entities.Tag

@Database(
    entities = [
        EntityFile::class,
        Tag::class
    ],
    version = 1
)
abstract class QuickIdDatabase : RoomDatabase() {
    abstract fun fileDao(): FileDao
    abstract fun tagDao(): TagDao
}

internal const val dbFileName = "QuickId.db"
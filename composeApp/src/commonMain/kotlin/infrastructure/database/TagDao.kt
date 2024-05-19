package infrastructure.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import infrastructure.entities.Tag
import kotlinx.coroutines.flow.Flow

@Dao
interface TagDao {
    @Insert
    suspend fun insert(tag: Tag)

    @Query("SELECT * FROM tags WHERE fileId = :fileId")
    fun getAllAsFlow(fileId: Int): Flow<List<Tag>>

}
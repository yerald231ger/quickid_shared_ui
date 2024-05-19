package infrastructure.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import infrastructure.entities.Tag
import kotlinx.coroutines.flow.Flow

@Dao
interface TagDao {
    @Insert
    fun insert(tag: Tag)

    @Query("SELECT * FROM tags WHERE fileId = :fileId")
    suspend fun getAllAsFlow(fileId: Int): List<Tag>

}
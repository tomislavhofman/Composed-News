package hr.hofman.composednews.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import hr.hofman.composednews.data.local.dao.HeadlinesDao
import hr.hofman.composednews.data.local.entity.HeadlineEntity

@Database(
    entities = [
        HeadlineEntity::class],
    version = 1
)
@TypeConverters(ComposedNewsTypeConverters::class)
abstract class ComposedNewsRoomDatabase : RoomDatabase(), ComposedNewsDatabase

interface ComposedNewsDatabase {
    fun headlinesDao(): HeadlinesDao
}
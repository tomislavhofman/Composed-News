package hr.hofman.composednews.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import hr.hofman.composednews.data.local.entity.HeadlineEntity
import io.reactivex.Flowable

@Dao
abstract class HeadlinesDao :
    EntityDao<HeadlineEntity> {

    @Query("SELECT * FROM headlines ORDER BY publishedAt DESC")
    abstract fun headlines(): Flowable<List<HeadlineEntity>>

    @Query("DELETE FROM headlines")
    abstract fun deleteAll()
}
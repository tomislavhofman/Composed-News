package hr.hofman.composednews.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import hr.hofman.composednews.data.local.entity.LastRequestEntity
import hr.hofman.composednews.data.local.Request
import io.reactivex.Completable

@Dao
abstract class LastRequestDao :
    EntityDao<LastRequestEntity> {
    @Query("SELECT * FROM last_requests WHERE request = :request AND entity_id = :entityId")
    abstract fun lastRequest(request: Request, entityId: Long): LastRequestEntity?

    @Query("SELECT COUNT(*) FROM last_requests WHERE request = :request AND entity_id = :entityId")
    abstract fun requestCount(request: Request, entityId: Long): Int

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override fun insert(entity: LastRequestEntity): Completable
}

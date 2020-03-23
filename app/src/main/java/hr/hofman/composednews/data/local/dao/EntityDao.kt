package hr.hofman.composednews.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import hr.hofman.composednews.data.local.entity.LocalEntity
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single

interface EntityDao<in E : LocalEntity> {
    @Insert
    fun insert(entity: E): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg entity: E): Maybe<List<Long>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(entities: List<E>): Maybe<List<Long>>

    @Update
    fun update(entity: E): Completable

    @Delete
    fun delete(entity: E): Single<Int>
}
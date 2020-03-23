package hr.hofman.composednews.data.local.entity

import hr.hofman.composednews.data.local.dao.EntityDao
import io.reactivex.Completable

interface EntityInserter {
    fun <E : LocalEntity> insertOrUpdate(dao: EntityDao<E>, entities: List<E>)
    fun <E : LocalEntity> insertOrUpdate(dao: EntityDao<E>, entity: E): Completable
}
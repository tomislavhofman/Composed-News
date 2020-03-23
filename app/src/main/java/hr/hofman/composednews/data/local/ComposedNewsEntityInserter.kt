package hr.hofman.composednews.data.local

import android.database.sqlite.SQLiteException
import hr.hofman.composednews.base.Logger
import hr.hofman.composednews.data.local.dao.EntityDao
import hr.hofman.composednews.data.local.entity.EntityInserter
import hr.hofman.composednews.data.local.entity.LocalEntity
import io.reactivex.Completable
import javax.inject.Inject

class ComposedNewsEntityInserter @Inject constructor(
    private val logger: Logger
) : EntityInserter {

    override fun <E : LocalEntity> insertOrUpdate(dao: EntityDao<E>, entities: List<E>) {
        entities.forEach {
            insertOrUpdate(dao, it)
        }
    }

    override fun <E : LocalEntity> insertOrUpdate(dao: EntityDao<E>, entity: E): Completable {
        logger.v("insertOrUpdate: %s", entity)

        return if (entity.id == 0L) {
            try {
                dao.insert(entity)
            } catch (e: SQLiteException) {
                throw SQLiteException("Error while inserting entity: $entity").apply {
                    initCause(e)
                }
            }
        } else {
            try {
                dao.update(entity)
            } catch (e: SQLiteException) {
                throw SQLiteException("Error while updating entity: $entity").apply {
                    initCause(e)
                }
            }
        }
    }
}
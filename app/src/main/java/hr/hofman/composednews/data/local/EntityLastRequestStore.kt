package hr.hofman.composednews.data.local

import hr.hofman.composednews.data.inPast
import hr.hofman.composednews.data.local.entity.LastRequestEntity
import hr.hofman.composednews.data.local.dao.LastRequestDao
import org.threeten.bp.Instant
import org.threeten.bp.temporal.TemporalAmount

open class EntityLastRequestStore(
    private val request: Request,
    private val dao: LastRequestDao
) {
    fun getRequestInstant(entityId: Long): Instant? {
        return dao.lastRequest(request, entityId)?.timestamp
    }

    fun isRequestExpired(entityId: Long, threshold: TemporalAmount): Boolean {
        return isRequestBefore(entityId, threshold.inPast())
    }

    fun hasBeenRequested(entityId: Long): Boolean = dao.requestCount(request, entityId) > 0

    fun isRequestBefore(entityId: Long, instant: Instant): Boolean {
        return getRequestInstant(entityId)?.isBefore(instant) ?: true
    }

    fun updateLastRequest(entityId: Long, timestamp: Instant = Instant.now()) {
        dao.insert(
            LastRequestEntity(
                request = request,
                entityId = entityId,
                timestamp = timestamp
            )
        )
    }

    suspend fun invalidateLastRequest(entityId: Long) = updateLastRequest(entityId, Instant.EPOCH)
}

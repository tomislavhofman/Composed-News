package hr.hofman.composednews.data.local

import hr.hofman.composednews.data.inPast
import hr.hofman.composednews.data.local.entity.LastRequestEntity
import hr.hofman.composednews.data.local.dao.LastRequestDao
import org.threeten.bp.Instant
import org.threeten.bp.temporal.TemporalAmount

open class GroupLastRequestStore(
    private val request: Request,
    private val dao: LastRequestDao
) {
    fun getRequestInstant(): Instant? {
        return dao.lastRequest(request,
            DEFAULT_ID
        )?.timestamp
    }

    fun isRequestExpired(threshold: TemporalAmount): Boolean {
        return isRequestBefore(threshold.inPast())
    }

    fun isRequestBefore(instant: Instant): Boolean {
        return getRequestInstant()?.isBefore(instant) ?: true
    }

    fun updateLastRequest(timestamp: Instant = Instant.now()) {
        dao.insert(
            LastRequestEntity(
                request = request,
                entityId = DEFAULT_ID,
                timestamp = timestamp
            )
        )
    }

    fun invalidateLastRequest() = updateLastRequest(Instant.EPOCH)

    companion object {
        private const val DEFAULT_ID = 0L
    }
}

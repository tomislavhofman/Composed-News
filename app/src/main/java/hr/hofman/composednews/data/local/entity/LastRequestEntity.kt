package hr.hofman.composednews.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import hr.hofman.composednews.data.local.Request
import org.threeten.bp.Instant

@Entity(
    tableName = "last_requests",
    indices = [Index(value = ["request", "entity_id"], unique = true)]
)
data class LastRequestEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id: Long = 0,
    @ColumnInfo(name = "request") val request: Request,
    @ColumnInfo(name = "entity_id") val entityId: Long,
    @ColumnInfo(name = "timestamp") val timestamp: Instant
) : LocalEntity
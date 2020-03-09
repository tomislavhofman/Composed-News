package hr.hofman.composednews.data.local

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import org.threeten.bp.Instant

@Entity
    (
    tableName = "headlines",
    indices = [
        Index(value = ["title"], unique = true)
    ]
)
data class Headline(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id: Long = 0,
    @Embedded val source: Source? = null,
    @ColumnInfo(name = "author") val author: String? = null,
    @ColumnInfo(name = "title") val title: String? = null,
    @ColumnInfo(name = "description") val description: String? = null,
    @ColumnInfo(name = "url") val url: String? = null,
    @ColumnInfo(name = "urlToImage") val urlToImage: String? = null,
    @ColumnInfo(name = "publishedAt") val publishedAt: Instant? = null
) : LocalEntity

data class Source(
    val id: String,
    val name: String
)